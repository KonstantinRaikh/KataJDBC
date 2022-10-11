package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();

        userDaoJDBC.createUsersTable();

        userDaoJDBC.saveUser("Kostya", "Raikh", (byte) 30);
        userDaoJDBC.saveUser("Marina", "Raikh", (byte) 35);
        userDaoJDBC.saveUser("Lesha", "Danilov", (byte) 37);
        userDaoJDBC.saveUser("Dima", "Danilov", (byte) 35);

        List<User> userList = userDaoJDBC.getAllUsers();
        System.out.println(userList);

        userDaoJDBC.cleanUsersTable();

        userDaoJDBC.dropUsersTable();


    }
}
