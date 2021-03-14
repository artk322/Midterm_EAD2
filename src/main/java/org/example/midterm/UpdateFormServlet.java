package org.example.midterm;

import org.example.midterm.dbConfig.DbData;
import org.example.midterm.model.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/Update")
public class UpdateFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.valueOf(request.getParameter("id"));
        Connection connection = DbData.getConnection();
        Note note = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Notes Where id=?");

            preparedStatement.setLong(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            note = new Note();

            note.setId(resultSet.getLong("id"));
            note.setTitle(resultSet.getString("title"));
            note.setDate(resultSet.getString("date"));
            note.setStatus(resultSet.getBoolean("status"));


            request.setAttribute("Note", note);
            request.getRequestDispatcher("update.jsp").include(request, response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
