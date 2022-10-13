package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        userService.createUsersTable();

        userService.saveUser("Kostya", "Raikh", (byte) 30);
        System.out.println("User с именем – Kostya добавлен в базу данных");
        userService.saveUser("Marina", "Raikh", (byte) 35);
        System.out.println("User с именем – Marina добавлен в базу данных");
        userService.saveUser("Lesha", "Danilov", (byte) 37);
        System.out.println("User с именем – Lesha добавлен в базу данных");
        userService.saveUser("Dima", "Danilov", (byte) 35);
        System.out.println("User с именем – Dima добавлен в базу данных");

        List<User> userList = userService.getAllUsers();
        System.out.println(userList);

        userService.cleanUsersTable();

        userService.dropUsersTable();
    }
}
