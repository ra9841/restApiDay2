package com.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.EmployeeDto;

@RequestMapping("/version1")
@RestController
public class MyRestController {
	
	@GetMapping("/employee")
	public EmployeeDto loginPage() {
		EmployeeDto employeeDto=new EmployeeDto(1,"Hari","hari@gmail.com","123",2000);
		return employeeDto;
	}
	
	@GetMapping("/employees")
     List<EmployeeDto> hipage() {
		EmployeeDto employeeDto1=new EmployeeDto(2,"Rabin","rabin@gmail.com","456",5000);
		EmployeeDto employeeDto2=new EmployeeDto(3,"Bijeta","bijeta@gmail.com","45678",5000);
		EmployeeDto employeeDto3=new EmployeeDto(4,"Bishal","bishal@gmail.com","45666",5000);
		EmployeeDto employeeDto4=new EmployeeDto(5,"Sarita","sarita@gmail.com","45655",5000);
		
		List<EmployeeDto>li=new ArrayList<>();
		li.add(employeeDto1);
		li.add(employeeDto2);
		li.add(employeeDto3);
		li.add(employeeDto4);
		return li;
	}
	
	@PostMapping("/registration")//@RequestBody must be used with @PostMapping...check
	EmployeeDto register(@RequestBody EmployeeDto employeeDto) {
		//save employeeDto to db
		//returning the registered employeeDto
		return employeeDto;
	}
}
