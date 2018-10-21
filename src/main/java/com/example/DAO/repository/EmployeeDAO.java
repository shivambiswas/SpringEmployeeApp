package com.example.DAO.repository;



import java.util.List;

import com.example.model.Employee;
public interface EmployeeDAO{
	
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(Long id);
	public Employee updateEmployee(Employee emp);
	public Employee deleteEmployee(Long id);
	public Employee addEmployee(Employee emp);

}


