package com.example.service;

import java.util.List;
import com.example.model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployee();
	public Employee getSingleEmployee(Long id);
	public Employee updateEmployee(Employee emp);
	public Employee deleteEmployee(Long id);
	public boolean addEmployee(Employee emp);

}
