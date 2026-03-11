package com.company.main;

import java.util.Scanner;

import com.company.employee.Employee;
import com.company.service.EmployeeService;
import com.company.exception.InvalidSalaryException;
import com.company.exception.EmployeeNotFoundException;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeService service = new EmployeeService();

        try {

            System.out.println("Enter Employee ID:");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.println("Enter Name:");
            String name = sc.nextLine();

            System.out.println("Enter Department:");
            String dept = sc.nextLine();

            System.out.println("Enter Salary:");
            double salary = sc.nextDouble();

            if(salary < 10000) {
                throw new InvalidSalaryException("Salary should be above 10000");
            }

            Employee e = new Employee(id, name, dept, salary);

            service.addEmployee(e);

            System.out.println("\nEmployees in file:");
            service.displayEmployees();

            System.out.println("\nEnter ID to search:");
            int searchId = sc.nextInt();

            service.searchEmployee(searchId);

        }
        catch(InvalidSalaryException e) {
            System.out.println(e.getMessage());
        }
        catch(EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch(Exception e) {
            System.out.println("Some error occurred");
        }

        sc.close();
    }
}