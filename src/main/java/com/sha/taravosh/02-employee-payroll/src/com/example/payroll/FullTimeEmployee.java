package com.sha.taravosh;

public class FullTimeEmployee extends Employee {
    private double baseSalary;
    private double bonus;

    public FullTimeEmployee(int employeeId, String name,
                            double baseSalary, double bonus) {
        super(employeeId, name);
        this.baseSalary = baseSalary;
        this.bonus = bonus;
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
