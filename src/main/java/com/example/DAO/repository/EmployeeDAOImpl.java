package com.example.DAO.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("deprecation")
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Employee.class).list();
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, emp.getId());
		employee.setName(emp.getName());
		employee.setSalary(emp.getSalary());
		employee.setTech(emp.getTech());
		session.update(employee);
		return employee;
	}

	@Override
	public Employee addEmployee(Employee emp) {
		try{
		Session session = sessionFactory.getCurrentSession();
		session.save(emp);
		return emp;
		}catch(Exception ex)
		{
			return null;
		}
	}

	@Override
	public Employee deleteEmployee(Long id) {
		try{
		Session session = sessionFactory.getCurrentSession();
        Employee employee = getEmployeeById(id);
        session.delete(employee);
        return employee;
		}catch(Exception ex)
		{
			return null;
		}
	}
	
	

}
