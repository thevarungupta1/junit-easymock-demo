package com.xebia.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import com.xebia.dao.EmployeeDao;

public class EmployeeServiceTest {
	
	// without mock which will give null
//	@Test
//	public void testGetNameById() {
//		// Triple A Rule
//		// Arrange
//		EmployeeService service = new EmployeeServiceImpl();
//		// Act
//		String name = service.getNameById(101);
//		// Assert
//		assertNotNull(name);	
//	}
	
	
	// with mock of employeeDao
	@Test
	public void testGetNameById() {
		
		// use EasyMock to create a mock object
		EmployeeDao daoProxy = EasyMock.createMock(EmployeeDao.class);
		
		// setting up the behaviour for proxy object
		EasyMock.expect(daoProxy.findNameById(101))
								.andReturn("Mark");
		
		EasyMock.expect(daoProxy.findNameById(102))
								.andReturn("Paul");
		
		EasyMock.replay(daoProxy);
		
		
		
		EmployeeServiceImpl service = new EmployeeServiceImpl();
		// use setter method to set mock object
		service.setEmployeeDao(daoProxy);
		
		// Act
		String name = service.getNameById(103);
		// Assert
		assertNotNull(name);	
	}
	
	
	

}
