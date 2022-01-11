package com.bridgelabz.jdbc.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTransaction {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            connection = new EmployeePayrollRepository().getConnection();
            connection.setAutoCommit(false);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //insert employee data
        int empId = 0;
        try (Statement statement1 = connection.createStatement()) {
            String sql = String.format("insert into employee(name,gender,startDate,phone_number,address) " +
                    "values ('%s','%s','%s',%s,'%s') ", "Terissa", "f", "2021-01-10", "8895465656", "Pune");
            int rowsAffected = statement1.executeUpdate(sql, statement1.RETURN_GENERATED_KEYS);
            if (rowsAffected == 1) {
                System.out.println("data added");
                System.out.println(statement1.getGeneratedKeys());
                ResultSet resultSet = statement1.getGeneratedKeys();
                if (resultSet.next()) {
                    empId = resultSet.getInt(1);
                }
            }
            System.out.println(empId);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            connection.rollback();
        }

        // insert payroll data
        double salary = 5200000;
        try (Statement statement1 = connection.createStatement()) {
            double deductions = salary * 0.2;
            double taxablePay = salary - deductions;
            double tax = taxablePay * 0.1;
            double netPay = salary - tax;
            String sql = String.format("insert into payroll(basic_pay,deductions,taxable_pay,income_tax,net_pay,emp_ID) " +
                    "values ('%f','%f','%f','%f','%f','%d')", salary, deductions, taxablePay, tax, netPay, empId);
            int rowAffected = statement1.executeUpdate(sql);
            if (rowAffected >= 1) {
                System.out.println("Payroll data added");
            }
        } catch (SQLException e) {
            System.out.println("exception" + e.getMessage());
            connection.rollback();
        } catch (Exception e) {
            System.out.println("exception" + e.getMessage());
        }
        try {
            connection.commit();
        } finally {
            connection.close();
        }
    }

}
