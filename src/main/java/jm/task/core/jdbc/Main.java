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
        System.out.println("User с именем – Kostya добавлен в базу данных");
        userDaoJDBC.saveUser("Marina", "Raikh", (byte) 35);
        System.out.println("User с именем – Marina добавлен в базу данных");
        userDaoJDBC.saveUser("Lesha", "Danilov", (byte) 37);
        System.out.println("User с именем – Lesha добавлен в базу данных");
        userDaoJDBC.saveUser("Dima", "Danilov", (byte) 35);
        System.out.println("User с именем – Dima добавлен в базу данных");

        List<User> userList = userDaoJDBC.getAllUsers();
        System.out.println(userList);

        userDaoJDBC.cleanUsersTable();

        userDaoJDBC.dropUsersTable();
    }
}
