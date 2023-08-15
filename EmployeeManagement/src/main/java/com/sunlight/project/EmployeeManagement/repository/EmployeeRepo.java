package com.sunlight.project.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sunlight.project.EmployeeManagement.DAO.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
}
