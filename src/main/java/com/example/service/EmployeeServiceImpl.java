package com.example.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.repository.EmployeeDAO;
import com.example.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDao;
	private static org.apache.log4j.Logger log = Logger.getLogger(EmployeeServiceImpl.class);
	
	@Override 
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		log.info("inside getAllEmployee of service class");
		List<Employee> list = employeeDao.getAllEmployee();
		log.info("Employee list after fetching from DB "+list);
		return list;
	}

	@Override
	public Employee getSingleEmployee(Long id) {
		// TODO Auto-generated method stub
		log.info("inside getSingleEmployee of service class");
		return employeeDao.getEmployeeById(id);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		// TODO Auto-generated method stub
		log.info("inside updateEmployee of service class");
		return employeeDao.updateEmployee(emp);
	}

	@Override
	public Employee deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		log.info("inside deleteEmployee of service class");
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public boolean addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		log.info("inside addEmployee of service class");
		Employee employee = employeeDao.addEmployee(emp);
		if(employee!= null)
			return true;
		else
		{
			log.error("Somthing went wrong");
			return false;
		}
	}

}
