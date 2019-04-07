package com.BMS.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";
    private static final String URL = "jdbc:mysql://localhost:3306/bms529?serverTimezone=GMT";
    private static final String PASS = "root";

    public static Connection getConnection() {
        try {
            Connection con = null;
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASS);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


};
