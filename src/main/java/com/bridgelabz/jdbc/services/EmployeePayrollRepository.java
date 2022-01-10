package com.bridgelabz.jdbc.services;

import com.bridgelabz.jdbc.model.EmployeeInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //retrieve data of all employee
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

    //Update salary of employee
    public void updateSalary(String name, int basic_pay) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            // String sqlQuery = "update employee set salary = " + salary + "where name = '" + name + "'";
            String sqlQuery = String.format("update employee_payroll set basic_pay = %d where name = '%s'", basic_pay, name);
            int result = statement.executeUpdate(sqlQuery);
            if (result >= 1) {
                System.out.println("salary updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //update salary using prepared statement
    public void updateSalaryUsingPreparedStatement(String name, int basic_pay) {
        try (Connection connection = getConnection()) {
            String query = "update employee_payroll set basic_pay = ? where name = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, basic_pay);
            preparedStatement.setString(2, name);
            int result = preparedStatement.executeUpdate();
            if (result >= 1) {
                System.out.println("salary updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //retrieve data of employee of particular date range
    public List<EmployeeInfo> retrieveDataByDateRange() {
        List<EmployeeInfo> employeeInfo = new ArrayList<>();
        try (Connection connection = getConnection()) {
            //step 3
            Statement statement = connection.createStatement();
            String sqlQuery = String.format("select * from employee_payroll where startDate between '2021-04-10' and date(now())");
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

    //Sum of salary by gender;
    public Map<String, Double> getSumOfSalaryByGender() {
        Map<String, Double> sumOfSalary = new HashMap<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "select gender,sum(basic_pay) as sum_salary from employee_payroll group by gender;";
            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {
                EmployeeInfo info = new EmployeeInfo();
                String gender = String.valueOf(resultset.getString("gender").charAt(0));
                Double sum_salary = Double.valueOf(resultset.getString("sum_salary"));
                sumOfSalary.put(gender, sum_salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sumOfSalary;
    }

    //average salary by gender
    public Map<String, Double> getAverageSalaryByGender() {
        Map<String, Double> avgSalary = new HashMap<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "select gender,avg(basic_pay) as avg_salary from employee_payroll group by gender;";
            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {
                EmployeeInfo info = new EmployeeInfo();
                String gender = String.valueOf(resultset.getString("gender").charAt(0));
                Double avg_salary = Double.valueOf(resultset.getString("avg_salary"));
                avgSalary.put(gender, avg_salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return avgSalary;
    }

    //maximum salary by gender
    public Map<String, Double> getMaxSalaryByGender() {
        Map<String, Double> maxSalary = new HashMap<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "select gender,max(basic_pay) as max_salary from employee_payroll group by gender;";
            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {
                EmployeeInfo info = new EmployeeInfo();
                String gender = String.valueOf(resultset.getString("gender").charAt(0));
                Double max_salary = Double.valueOf(resultset.getString("max_salary"));
                maxSalary.put(gender, max_salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxSalary;
    }

    //mimimum salary by gender
    public Map<String, Double> getMinSalaryByGender() {
        Map<String, Double> minSalary = new HashMap<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "select gender,min(basic_pay) as min_salary from employee_payroll group by gender;";
            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {
                EmployeeInfo info = new EmployeeInfo();
                String gender = String.valueOf(resultset.getString("gender").charAt(0));
                Double min_salary = Double.valueOf(resultset.getString("min_salary"));
                minSalary.put(gender, min_salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return minSalary;
    }

    //count by gender
    public Map<String, Integer> getCountByGender() {
        Map<String, Integer> countByGender = new HashMap<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "select gender,count(*) as count from employee_payroll group by gender";
            ResultSet resultset = statement.executeQuery(query);
            while (resultset.next()) {
                EmployeeInfo info = new EmployeeInfo();
                String gender = String.valueOf(resultset.getString("gender").charAt(0));
                Integer count = Integer.valueOf(resultset.getString("count"));
                countByGender.put(gender, count);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countByGender;
    }
}
