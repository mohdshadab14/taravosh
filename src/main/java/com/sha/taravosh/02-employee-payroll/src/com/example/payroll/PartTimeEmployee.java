package com.sha.taravosh;

public class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(int employeeId, String name,
                            double hourlyRate, int hoursWorked) {
        super(employeeId, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
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
