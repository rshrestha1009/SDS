package com.EmployeeManagmentSystem.EDS.repository;

import com.EmployeeManagmentSystem.EDS.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
