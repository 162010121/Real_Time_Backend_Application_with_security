package com.emp.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.emp.dto.EmployeeDTO;
import com.emp.entity.EmployeeEntity;
import com.emp.repo.EmployeeRepo;
import com.emp.service.EmployeeService;

@ExtendWith(MockitoExtension.class)

public class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepo respository;

	@Mock
	private EmployeeService service;

	AutoCloseable autoCloseable;

	EmployeeDTO employeeDTO;

	@BeforeEach
	void setUp() {

		autoCloseable = MockitoAnnotations.openMocks(this);
	}

	@AfterEach
	void tearDown() throws Exception {
		autoCloseable.close();

	}

//	@Test
//	void testCreateEmployee() throws Exception {
//
//		EmployeeDTO empDto = new EmployeeDTO(1, "Praveen", "Pustera", "Praveen@email.com", "Praveen@123", "IAS", 10000,
//				"");
//		
//		EmployeeEntity entity=new EmployeeEntity();
//
//		when(respository.save(entity)).thenReturn(entity);
//		assertEquals(entity, service.saveDetails(empDto));
//
//	}
	
	@Test
	@DisplayName("Should save the movie Object")
	void testInsertEmployee_Success() throws Exception
	{
		EmployeeEntity employeeEntity=new EmployeeEntity();
		employeeEntity.setId(1L);
		employeeEntity.setFristName("Praveen");
		employeeEntity.setLastName("Pusteta");
		
		when(respository.save(any(EmployeeEntity.class))).thenReturn(employeeEntity);
		
		
		EmployeeDTO empDTO=service.saveDetails(employeeDTO);
		assertNotNull(empDTO);
		assertThat(empDTO.getFristName()).isEqualTo("Praveen");
		
	}
	
}
