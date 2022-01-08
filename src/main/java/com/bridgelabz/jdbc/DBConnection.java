package com.bridgelabz.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static void main(String[] args) {
        //step 1 Load the driver class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("driver is not loaded");
        }

        //step 2 create connection
        String JDBCURL = "jdbc:mysql://localhost:3307/emp_payroll_service";
        try {
            DriverManager.getConnection(JDBCURL, "root", "root");
            System.out.println("Connection is established");
        } catch (SQLException e) {
            System.out.println("connection not established");
        }
    }

}
