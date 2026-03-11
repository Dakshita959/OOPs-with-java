package com.company.exception;

public class EmployeeNotFoundException extends Exception {

    public EmployeeNotFoundException(String msg) {
        super(msg);
    }
}