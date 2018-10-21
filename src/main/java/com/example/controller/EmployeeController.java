package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("emp")
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/getemps")
	public List<Employee> getEmployees()
	{
		List<Employee> list = service.getAllEmployee();
		return list;
	}
	@RequestMapping("/getempid")
	public ResponseEntity<Employee> getEmployeeById(@RequestParam(value="id") int id)
	{
		Employee emp = service.getSingleEmployee(new Long(id));
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/create",headers="Accept=application/json")
	public ResponseEntity<Object> addEmployee(@RequestBody Employee emp)
	{
		boolean flag = service.addEmployee(emp);
		if (flag)
		{
			return new ResponseEntity<Object>(emp,HttpStatus.OK);
		}
		else
			return new ResponseEntity<Object>("Failure",HttpStatus.CONFLICT);
	}
	
	@PutMapping(value="/update",headers="Accept=application/json")
	public ResponseEntity<Object> updateEmployee(@RequestBody Employee emp)
	{
		try{
			service.updateEmployee(emp);
			return new ResponseEntity<Object>(emp,HttpStatus.OK);
		}catch(Exception ex)
		{
			return new ResponseEntity<Object>("Failure",HttpStatus.CONFLICT);
		}
	}
	@DeleteMapping("/delete")
	public ResponseEntity<Object> deleteEmployee(@RequestParam(value="id") int id)
	{
		Employee employee = service.getSingleEmployee(new Long(id));
        if (employee == null) {
            return new ResponseEntity<Object>("Failure",HttpStatus.NOT_FOUND);
        }
        service.deleteEmployee(new Long(id));
        return new ResponseEntity<Object>(employee,HttpStatus.OK);
	}

}
