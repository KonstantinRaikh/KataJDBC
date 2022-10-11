package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getConnection(){
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER, PASS);
        }catch (SQLException ignore){
        }
        return connection;
    }

    public static Statement getStatement(){
        Statement statement = null;
        try{
            statement = Util.getConnection().createStatement();
        }catch (SQLException ignore){
        }
        return statement;
    }

}
