package ru.notesite.project.dao;

import ru.notesite.project.dbconnection.DbConnection;
import ru.notesite.project.models.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO {

    public Integer createUser(Person person) {
        int count = 1;
        try (Connection connection = new DbConnection().dbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select login, password from users")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                if (person.getName().equals(resultSet.getString("login"))) {
                    count = 0;
                }
            }
            if (count == 1) {
                try (PreparedStatement preparedStatementCreateUser = connection.prepareStatement(
                        "insert into users (login, password) values (?, ?)")) {
                    preparedStatementCreateUser.setString(1, person.getName());
                    preparedStatementCreateUser.setString(2, person.getPassword());
                    preparedStatementCreateUser.executeUpdate();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public Integer logIn(Person person) {
        int count = 0;
        try (Connection connection = new DbConnection().dbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select id, login, password from users")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                if (person.getName().equals(resultSet.getString("login")) && person.getPassword().equals(resultSet.getString("password"))) {
                    person.setId(resultSet.getInt("id"));
                    count = 1;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    public Person showNotes(Person person) {
        try (Connection connection = new DbConnection().dbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select notes from notes where user_id = ?")) {
            preparedStatement.setInt(1, person.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                person.getArrayListNotes().add(resultSet.getString("notes"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }

    public void createNote(Person person) {
        try (Connection connection = new DbConnection().dbConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "insert into notes (user_id, notes) values (?,?)")) {
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getNote());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
