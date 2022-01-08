package com.bridgelabz.jdbc.services;

import java.util.Locale;

public class EmployeePayrollService {

    EmployeePayrollRepository repository = new EmployeePayrollRepository();
    public static void main(String[] args) {
        EmployeePayrollService service = new EmployeePayrollService();
        service.retrieveData();
        service.updateSalary("Terissa", 3000000);
    }

    private void retrieveData() {
        System.out.println(repository.retrieveData());
    }

    private void updateSalary(String name, int basic_pay) {
        repository.updateSalaryUsingPreparedStatement(name.toLowerCase(Locale.ROOT), basic_pay);
    }
}
