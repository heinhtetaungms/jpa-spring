package com.ace.service;

import java.sql.Date;

import com.ace.dao.EmployeeDao;
import com.ace.ds.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	public void saveEmployeesUnderOneTransaction() {
		System.out.println("Saving Employee with JPA...");
		employeeDao.save(new Employee("John","john@gmail.com","09761122464",Date.valueOf("2022-07-26"), 700000));
		System.out.println("Saved Employee with JPA...");
	}
	@Transactional
	public void listAllEmployee() {
		System.out.println("Listing all employees...");
		employeeDao.findAll().forEach(System.out::println);
	}
}
