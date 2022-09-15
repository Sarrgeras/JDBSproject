package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private final static String URL = "db.url";
    private final static String USERNAME = "db.username";
    private final static String PASSWORD = "db.password";

    static {
        loadDriver();
    }


    private static void loadDriver(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public static Connection open(){
        try {
            return DriverManager.getConnection(
                    PropertiesUtil.get(URL),
                    PropertiesUtil.get(USERNAME),
                    PropertiesUtil.get(PASSWORD));
        } catch (SQLException e) {
            throw new RuntimeException("Не удалось соединится с базой данных");
        }
    }


}
