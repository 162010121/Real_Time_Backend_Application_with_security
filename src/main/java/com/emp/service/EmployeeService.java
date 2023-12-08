package com.emp.service;

import java.util.List;

import com.emp.dto.EmployeeDTO;
import com.emp.entity.EmployeeEntity;

public interface EmployeeService {

//	public EmployeeDTO saveDetails(EmployeeDTO entity);
//
//	public EmployeeDTO updateDetails(EmployeeDTO entity, Long id);
//
//	public EmployeeDTO getEmployee(Long id);
//
//	public void deleteEmployee(Long id);
//
//	public List<EmployeeDTO> getAllEmployee();
//
//	public EmployeeDTO findByFristnameAndLastname(String firstName, String lastName);
	
	
	
	public EmployeeDTO saveDetails(EmployeeDTO empDTO);

	public EmployeeDTO updateDetails(EmployeeDTO empDTO);

	public EmployeeEntity getEmployee(Long id);

	public void deleteEmployee(Long id);

	public List<EmployeeEntity> getAllEmployee();

	public EmployeeEntity findByFristnameAndLastname(String firstName, String lastName);

}
