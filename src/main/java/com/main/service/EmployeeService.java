package com.main.service;

import java.util.List;

import com.main.dto.EmployeeDto;

public interface EmployeeService {

	List<EmployeeDto> show();

	void register(EmployeeDto employeeDto);

	EmployeeDto fetchRecord(int employeeId);

	void deleteRecord(int employeeId);

	EmployeeDto updateEmployeeName(int employeeId,String employeeName);

}
