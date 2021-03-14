package org.example.midterm;

import org.example.midterm.dbConfig.DbData;

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

@WebServlet("/Delete")
public class DeleteNoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.valueOf(request.getParameter("id"));



        Connection connection = DbData.getConnection();

        String userId = null;

        Cookie ck[] = request.getCookies();

        if(ck != null){
            int  i = 0;
            while (!ck[i].getName().equals("userId")) {
                i++;
            }

            userId = ck[i].getValue();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Notes WHERE id=? and user_id=?");

            preparedStatement.setLong(1, id);
            preparedStatement.setLong(2, Long.parseLong(userId));

            preparedStatement.executeUpdate();


            request.getRequestDispatcher("/ViewNotesServlet").include(request,response);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
