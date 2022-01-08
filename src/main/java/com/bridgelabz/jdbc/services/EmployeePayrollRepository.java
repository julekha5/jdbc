package com.bridgelabz.jdbc.services;

import com.bridgelabz.jdbc.model.EmployeeInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollRepository {

    private Connection getConnection() {
        Connection connection = null;
        try {
            String JDBCURL = "jdbc:mysql://localhost:3307/emp_payroll_service";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBCURL, "root", "root");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Driver not loaded");
        }
        return connection;
    }

    public List<EmployeeInfo> retrieveData() {
        List<EmployeeInfo> employeeInfo = new ArrayList<>();
        try (Connection connection = getConnection()) {
            //step 3
            Statement statement = connection.createStatement();
            String sqlQuery = "select * from employee_payroll";
            ResultSet resultset = statement.executeQuery(sqlQuery);
            while (resultset.next()) {
                EmployeeInfo info = new EmployeeInfo();
                info.setId(resultset.getInt("id"));
                info.setName(resultset.getString("name"));
                info.setGender(resultset.getString("gender").charAt(0));
                info.setAddress(resultset.getString("address"));
                info.setPhone_number(resultset.getString("phone_number"));
                info.setStartDate(Date.valueOf(resultset.getDate("startDate").toLocalDate()));
                employeeInfo.add(info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeInfo;
    }
}
