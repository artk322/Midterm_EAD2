package org.example.midterm;

import org.example.midterm.dbConfig.DbData;
import org.example.midterm.model.Note;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ViewNotesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Note> noteList = new ArrayList<>();
        Connection connection = DbData.getConnection();

        String userId = null;
        Cookie ck[] = request.getCookies();

        if (ck != null) {
            int index = 0;
            while (!ck[index].getName().equals("userId")) {
                index++;
            }

            userId = ck[index].getValue();
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Notes WHERE user_id=? ORDER BY id");

            preparedStatement.setLong(1, Long.parseLong(userId));

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Note note = new Note();

                note.setId(resultSet.getLong("id"));
                note.setTitle(resultSet.getString("title"));
                note.setDate(resultSet.getString("date"));
                note.setStatus(resultSet.getBoolean("status"));


                noteList.add(note);
            }

            request.setAttribute("NoteList", noteList);
            request.getRequestDispatcher("viewMyNotes.jsp").include(request, response);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}