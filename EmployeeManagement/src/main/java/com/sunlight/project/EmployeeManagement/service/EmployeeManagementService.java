package com.sunlight.project.EmployeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunlight.project.EmployeeManagement.DAO.Employee;
import com.sunlight.project.EmployeeManagement.repository.EmployeeRepo;

@Service
public class EmployeeManagementService {
	
	@Autowired
	private EmployeeRepo empRepo;
	int id =1;
	
	public Optional<Employee> readEmployeeService() {
		Optional<Employee> Emp = empRepo.findById(id);
		
		return Emp;
	}
	
	public Employee addEmployeeService(String firstName,String lastName, String email,String phone,String designation) {
		
		Employee emp = new Employee();
		
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		emp.setEmail(email);
		emp.setPhone(phone);
		emp.setDesignation(designation);
		
		empRepo.save(emp);
		return emp;		
	}
	
	public void deleteEmployeeService(int id) {
		empRepo.deleteById(id);
	}
	
	public void updateEmployeeService(int id, Employee emp) {
		Employee empExisting = empRepo.findById(id).get();
		
		empExisting.setEmail(emp.getEmail());
		empExisting.setFirstName(emp.getFirstName());
		empExisting.setLastName(emp.getLastName());
		
		empRepo.save(empExisting);
	}
	
	public List<Employee> getAllEmployeesService() {
		return empRepo.findAll();

	}
}
