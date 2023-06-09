package com.main.dto;

public class EmployeeDto {
	int employeeId;
	String employeeName;
	String emailId;
	String password;
	int salary;
	
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDto(int employeeId, String employeeName, String emailId, String password, int salary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.emailId = emailId;
		this.password = password;
		this.salary = salary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeDto [employeeId=" + employeeId + ", employeeName=" + employeeName + ", emailId=" + emailId
				+ ", password=" + password + ", salary=" + salary + "]";
	}
	

}
