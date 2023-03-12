package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.main.dto.EmployeeDto;
import com.main.service.EmployeeService;

@RequestMapping("/version2")
@RestController
public class FrontController {
	
	@Autowired
	EmployeeService employeeService;
	
	//fetching all record
	@GetMapping("/employees")//localhost:444/version2/employees
	List<EmployeeDto> showAll(){
		List<EmployeeDto>employeeDto=employeeService.show();
		
		return employeeDto;
	}
	
	//for registration
	@PostMapping("/employees")//localhost:444/version2/employees
	ResponseEntity<String> registration(@RequestBody EmployeeDto employeeDto) {//@RequestBody is used in replace of @ModelAttribute in RestApi
		employeeService.register(employeeDto);
		
		return new ResponseEntity<>("register successfully",HttpStatus.CREATED);
	}
	
	//for retriveing record with help of primary key
	@GetMapping("/employees/{employeeId}") //localhost:444/version2/employees/1
	EmployeeDto fetchEmp(@PathVariable int employeeId) {  //@PathVariable is used in replace of @RequestParam in RestApi
		EmployeeDto employeeDto=employeeService.fetchRecord(employeeId);
		
		return employeeDto;
	}
	//for deleting a record
	@DeleteMapping("/employees/{employeeId}")
	ResponseEntity<String> deleteRecord(@PathVariable int employeeId) {
		employeeService.deleteRecord(employeeId);
		return new ResponseEntity<>("delete successfully",HttpStatus.OK);
	}
	
	//for updating a record
	@PutMapping("/employees")//localhost:444/version2/employees
	ResponseEntity<String> update(@RequestBody EmployeeDto employeeDto) {//@RequestBody is used in replace of @ModelAttribute in RestApi
		employeeService.register(employeeDto);
		
		return new ResponseEntity<>("updated successfully",HttpStatus.OK);
	}

	//for updating a record
		@PutMapping("/employees/{employeeId}")//localhost:444/version2/employees/1
		ResponseEntity<String> updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable int employeeId) {//@RequestBody is used in replace of @ModelAttribute in RestApi
			employeeDto.setEmployeeId(employeeId);
			employeeService.register(employeeDto);
			
			return new ResponseEntity<>("updated successfully through path variable",HttpStatus.OK);
		}
		
		//for updating employeeName
		@PatchMapping("/employees/{employeeId}/{employeeName}")//localhost:444/version2/employees/1/kabin
		ResponseEntity<EmployeeDto> updateEmployeeName(@PathVariable int employeeId,@PathVariable String employeeName) {
			EmployeeDto employeeDto=employeeService.updateEmployeeName(employeeId,employeeName);
			
			return new ResponseEntity<>(employeeDto,HttpStatus.OK);
		}
		
		


}
