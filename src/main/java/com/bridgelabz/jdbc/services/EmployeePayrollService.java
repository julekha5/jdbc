package com.bridgelabz.jdbc.services;

import java.util.Locale;

public class EmployeePayrollService {

    EmployeePayrollRepository repository = new EmployeePayrollRepository();

    public void retrieveData(String sqlQuery) {
        System.out.println(repository.retrieveData());
    }

    public void updateSalary(String name, int basic_pay) {
        repository.updateSalary(name.toLowerCase(Locale.ROOT), basic_pay);
    }

    public void updateSalaryUsingPreparedStatement(String name, int basic_pay) {
        repository.updateSalaryUsingPreparedStatement(name.toLowerCase(Locale.ROOT), basic_pay);
    }

    public void retrieveDataByDate(String sqlQuery) {
        System.out.println(repository.retrieveDataByDateRange());
    }

    public void getSumOfSalaryByGender(String sqlQuery){
        System.out.println(repository.getSumOfSalaryByGender());
    }

    public void getAverageSalaryByGender(String sqlQuery){
        System.out.println(repository.getAverageSalaryByGender());
    }

    public void getMaxSalaryByGender(String sqlQuery) {
        System.out.println(repository.getMaxSalaryByGender());
    }

    public void getMinSalaryByGender(String sqlQuery){
        System.out.println(repository.getMinSalaryByGender());
    }

    public void getCountByGender(String sqlQuery){
        System.out.println(repository.getCountByGender());
    }

//    public static void main(String[] args) {
//        EmployeePayrollService service = new EmployeePayrollService();
//        String sqlQuery = null;
//        service.retrieveData(null);
//        service.updateSalary("Julekha", 4000000);
//        service.updateSalaryUsingPreparedStatement("Kajal", 6200000);
//        service.retrieveDataByDate(null);
//        service.getSumOfSalaryByGender(null);
//        service.getAverageSalaryByGender(null);
//        service.getMaxSalaryByGender(null);
//        service.getMinSalaryByGender(null);
//        service.getCountByGender(null);
//    }
}
