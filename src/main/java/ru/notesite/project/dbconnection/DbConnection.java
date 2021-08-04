package ru.notesite.project.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection dbConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/fastnotes",
                "postgres",
                "1106935");
    }

}
