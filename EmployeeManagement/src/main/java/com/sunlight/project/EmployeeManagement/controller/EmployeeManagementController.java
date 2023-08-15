package com.sunlight.project.EmployeeManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sunlight.project.EmployeeManagement.DAO.Employee;
import com.sunlight.project.EmployeeManagement.service.EmployeeManagementService;

@Controller
public class EmployeeManagementController {

    @Autowired
    private EmployeeManagementService ems;
    
    ModelAndView mv = new ModelAndView();

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/addEmployee")
    public ModelAndView addNewEmpController(@RequestParam("firstName") String firstName,
    		@RequestParam("lastName") String lastName,
    		@RequestParam("email") String email,
    		@RequestParam("phone") String phone,
    		@RequestParam("designation") String designation) {
    	
    	ems.addEmployeeService(firstName, lastName, email, phone, designation);
    	
    	mv.setViewName("success.html");
		return mv;
        
    }

//    @GetMapping("/deleteEmployee")
//    public String deleteEmpController() {
//        return "deleteEmp";
//    }

    @GetMapping("/deleteEmployee")
    public ModelAndView deleteEmployee(@RequestParam int employeeId) {
        ems.deleteEmployeeService(employeeId);
        ModelAndView mv = new ModelAndView("deleteEmp");
        mv.addObject("message", "Employee with ID " + employeeId + " deleted successfully.");
        return mv;
    }

    @GetMapping("/updateEmp")
    public String updateEmp() {
        return "updateEmp";
    }

    @PostMapping("/updateEmployee")
    public ModelAndView updateEmployee(
        @RequestParam int employeeId,
        @RequestParam String firstName,
        @RequestParam String lastName,
        @RequestParam String email) {
        
        Employee updatedEmployee = new Employee();
        updatedEmployee.setFirstName(firstName);
        updatedEmployee.setLastName(lastName);
        updatedEmployee.setEmail(email);
        
        ems.updateEmployeeService(employeeId, updatedEmployee);
        
        ModelAndView mv = new ModelAndView("updateEmp");
        mv.addObject("message", "Employee with ID " + employeeId + " updated successfully.");
        return mv;
    }

    @GetMapping("/allEmp")
    public ModelAndView getAllEmployees() {
        ModelAndView mv = new ModelAndView("allEmp");
        mv.addObject("employees", ems.getAllEmployeesService());
        return mv;
    }
}
