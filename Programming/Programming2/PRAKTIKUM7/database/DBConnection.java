package PRAKTIKUM7.database;

import java.sql.*;

public class DBConnection {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/java"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 

    public static Connection connect() throws Exception{
        Class.forName(JDBC_DRIVER);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
