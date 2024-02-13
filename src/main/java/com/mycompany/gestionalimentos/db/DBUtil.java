package com.mycompany.gestionalimentos.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    
    private static String url = "jdbc:mysql://localhost:3307/uniminuto";
    private static String user = "root";
    private static String password = "123456";
    
    public static Connection obtenerConexionMysql() throws SQLException {
       return DriverManager.getConnection(url, user, password);
    }
}
