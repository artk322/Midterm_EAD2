package org.example.midterm;

import org.example.midterm.dbConfig.DbData;
import org.example.midterm.exception.DateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddNoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId = null;
        String title = request.getParameter("title");
        String date = request.getParameter("date");
        String status = request.getParameter("status");
        Connection connection = DbData.getConnection();

        Cookie ck[] = request.getCookies();

        if (ck != null) {
            int i = 0;
            while (!ck[i].getName().equals("userId")) {
                i++;
            }

            userId = ck[i].getValue();
        }

        try {

            if (!date.matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")) {

                throw new DateException("Incorrect date DD/MM/YYYY");
            }

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Notes(title, date, status, user_id)  VALUES(?,?, ?, ?)");

            preparedStatement.setString(1, title);
            preparedStatement.setString(2, date);
            preparedStatement.setBoolean(3, Boolean.parseBoolean(status));
            preparedStatement.setLong(4, Long.parseLong(userId));

            preparedStatement.executeUpdate();

            String notify;

            notify = "The note has been added";


            request.setAttribute("message", notify);
            request.getRequestDispatcher("addNote.jsp").include(request, response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addNote.jsp").include(request, response);
    }
}
