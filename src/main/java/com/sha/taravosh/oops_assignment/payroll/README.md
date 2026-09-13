# Assignment 02: Employee Payroll System

## Objective
Create a payroll system that calculates salaries for different employee types using abstraction and polymorphism.

## Requirements
1. Create an abstract `Employee` class.
2. Create `FullTimeEmployee`, `PartTimeEmployee`, and `ContractEmployee`.
3. Store employees in `ArrayList<Employee>`.
4. Calculate salary using overridden methods.
5. Display all employees.
6. Calculate total payroll.
7. Find the employee with the highest salary.
8. Display employees earning more than ₹50,000.

## Salary Rules
- Full-time: base salary + bonus
- Part-time: hourly rate × hours worked
- Contract: fixed contract amount

## Important Rule
The main application should call `employee.calculateSalary()` without checking the subclass type.
