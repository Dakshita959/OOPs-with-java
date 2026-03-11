package com.company.service;

import java.io.*;
import com.company.employee.Employee;
import com.company.exception.EmployeeNotFoundException;

public class EmployeeService {

    String file = "employees.txt";

    public void addEmployee(Employee e) {

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(e.empId + "," + e.name + "," + e.department + "," + e.salary);
            bw.newLine();

            bw.close();
        }
        catch(Exception ex) {
            System.out.println("Error while writing file");
        }
    }

    public void displayEmployees() {

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close();
        }
        catch(Exception e) {
            System.out.println("Error while reading file");
        }
    }

    public void searchEmployee(int id) throws EmployeeNotFoundException {

        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while((line = br.readLine()) != null) {

                String arr[] = line.split(",");

                int empId = Integer.parseInt(arr[0]);

                if(empId == id) {
                    System.out.println("Employee Found:");
                    System.out.println(line);
                    found = true;
                }
            }

            br.close();
        }
        catch(Exception e) {
            System.out.println("Error reading file");
        }

        if(found == false) {
            throw new EmployeeNotFoundException("Employee not found");
        }
    }
}