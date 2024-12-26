package com.tcs.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.springmvc.employee.Employeeclass;


@Controller
public class EmployeeController {

	@GetMapping("/employeeform")
	public String getMethodName() {
		return "emp";
	}
		
    @PostMapping("/saveemployee")
    public String postEmployee(Employeeclass employeeclass) {
    	 
    	System.out.println(employeeclass);
    	return  "success1";
    }
	
	
}