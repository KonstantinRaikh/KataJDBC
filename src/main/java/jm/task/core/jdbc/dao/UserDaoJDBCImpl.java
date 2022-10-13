package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = Util.getStatement()) {
            statement.execute("CREATE DATABASE IF NOT EXISTS test;");
            statement.execute("CREATE TABLE IF NOT EXISTS test.users" +
                    "(id INT PRIMARY KEY AUTO_INCREMENT," +
                    "name VARCHAR(15)," +
                    "last_name VARCHAR(15)," +
                    "age int);");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = Util.getStatement()) {
            statement.execute("DROP TABLE IF EXISTS test.users;");
            statement.execute("DROP DATABASE IF EXISTS test;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = Util.getConnection().prepareStatement
                ("INSERT INTO test.users (name, last_name, age) VALUES (?,?,?);");
             Statement statement = Util.getStatement()) {
            statement.execute("START TRANSACTION;");
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.execute();
            statement.execute("COMMIT;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement preparedStatement = Util.getConnection()
                .prepareStatement("DELETE FROM test.users WHERE id = (?);");
             Statement statement = Util.getStatement()) {
            statement.execute("START TRANSACTION;");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            statement.execute("COMMIT;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try (ResultSet resultSet = Util.getStatement().executeQuery("SELECT * FROM test.users;")) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        try (Statement statement = Util.getStatement()) {
            statement.execute("TRUNCATE TABLE test.users;");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
