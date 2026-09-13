package com.sha.taravosh.oops_assignment.payroll;

public class ContractEmployee extends Employee {
    private double contractAmount;

    public ContractEmployee(int employeeId, String name, double contractAmount) {
        super(employeeId, name);
        this.contractAmount = contractAmount;
    }

    @Override
    public double calculateSalary() {
        // TODO
        return 0;
    }

    @Override
    public void displayRole() {
        // TODO
    }
}
