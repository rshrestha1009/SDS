package com.EmployeeManagmentSystem.EDS.service;

import com.EmployeeManagmentSystem.EDS.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    String deleteEmployee(long id);
}
