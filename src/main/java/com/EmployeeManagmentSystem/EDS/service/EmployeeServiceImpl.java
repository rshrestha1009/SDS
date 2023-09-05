package com.EmployeeManagmentSystem.EDS.service;

import com.EmployeeManagmentSystem.EDS.entity.Employee;
import com.EmployeeManagmentSystem.EDS.exception.ResourceNotFoundException;
import com.EmployeeManagmentSystem.EDS.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employeeOptional =  employeeRepo.findById(id);
        if(employeeOptional.isPresent()){
            return employeeOptional.get();
        }else{
            throw new RuntimeException("Employee not found");
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //whether employee is exist in DB or not
        Employee existingEmployee = employeeRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
       existingEmployee.setFirstName(employee.getFirstName());
       existingEmployee.setLastName(employee.getLastName());
       existingEmployee.setEmail(employee.getEmail());
       employeeRepo.save(existingEmployee);
       return existingEmployee;
    }

    @Override
    public String deleteEmployee(long id) {
        String result = "";
        //check whether employee exist in a DB or not
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(()->
                            new ResourceNotFoundException("Employee", "id", id));
        employeeRepo.deleteById(id);
        return "success";
    }
}
