package com.xebia.service;

import com.xebia.dao.EmployeeDao;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao;
	
	public String getNameById(Integer id) {
		
		String name = employeeDao.findNameById(id);
		
		// logic
		String newName = name.toUpperCase();
		return newName;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	

}
