package com.bridgelabz.jdbc.services;

public class EmployeePayrollService {

    EmployeePayrollRepository repository = new EmployeePayrollRepository();

    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();
        service.retrieveData();
    }

    private void retrieveData() {
        System.out.println(repository.retrieveData());
    }
}
