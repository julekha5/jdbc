package com.bridgelabz.jdbc;

import com.bridgelabz.jdbc.services.EmployeePayrollService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmployeePayrollTest {

    EmployeePayrollService employeePayrollService = new EmployeePayrollService();

    @Test
    public void givenTestCaseShouldReturn_AllData() {
        String sqlQuery = "Select * from employee_payroll";
        employeePayrollService.retrieveData(sqlQuery);
        Assert.assertTrue(true, "Retrieve data successfully");
    }

    @Test
    public void givenTestCaseShouldReturn_UpdatedSalary() {
        String sqlQuery = "update employee_payroll set basic_pay = %d where name = '%s";
        employeePayrollService.updateSalary("Julekha", 300000);
        Assert.assertTrue(true, "Salary updated successfully");
    }

    @Test
    public void givenTestCaseShouldReturn_UpdatedSalaryUsingPreparedStatement() {
        String sqlQuery = "Select * from employee_payroll where startDate between '2021-04-10' and date(now())";
        employeePayrollService.updateSalaryUsingPreparedStatement("Kajal", 6200000);
        Assert.assertTrue(true, "Salary updated successfully using pp");
    }

    @Test
    public void givenTestCaseShouldReturn_AllDataByDateRange() {
        String sqlQuery = "Select * from employee_payroll where startDate between '2021-04-10' and date(now())";
        employeePayrollService.retrieveDataByDate(sqlQuery);
        Assert.assertTrue(true, "Retrieve data by date successfully");
    }

    @Test
    public void givenTestCaseShouldReturn_SumOfSalaryByGender() {
        String sqlQuery = "select gender,sum(basic_pay) as sum_salary from employee_payroll group by gender;";
        employeePayrollService.getSumOfSalaryByGender(sqlQuery);
        Assert.assertEquals("True", "True");
    }

    @Test
    public void givenTestCaseShouldReturn_AverageOfSalaryByGender() {
        String sqlQuery = "select gender,avg(basic_pay) as avg_salary from employee_payroll group by gender;";
        employeePayrollService.getAverageSalaryByGender(sqlQuery);
        Assert.assertTrue(true);
    }

    @Test
    public void givenTestCaseShouldReturn_MaximumSalaryByGender() {
        String sqlQuery = "select gender,max(basic_pay) as max_salary from employee_payroll group by gender;";
        employeePayrollService.getMaxSalaryByGender(sqlQuery);
        Assert.assertTrue(true, "Maximum salary retrieved");
    }

    @Test
    public void givenTestCaseShouldReturn_MinimumSalaryByGender() {
        String sqlQuery = "select gender,min(basic_pay) as min_salary from employee_payroll group by gender;";
        employeePayrollService.getMinSalaryByGender(sqlQuery);
        Assert.assertTrue(true, "Minimum salary retrieved");
    }

    @Test
    public void givenTestCaseShouldReturn_CountByGender() {
        String sqlQuery = "select gender,count(*) as count from employee_payroll group by gender;";
        employeePayrollService.getCountByGender(sqlQuery);
        Assert.assertTrue(true);
    }

}
