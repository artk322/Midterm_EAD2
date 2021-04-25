package org.example.midterm.dbConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbData {


    public static Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection( "jdbc:postgresql://localhost:5432/notes_db_ead2", "postgres", "postgres");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
