package com.emp.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emp.dto.EmployeeDTO;
import com.emp.dto.EmployeeLoginDTO;
import com.emp.dto.EmployeeLogout;
import com.emp.entity.EmployeeEntity;
import com.emp.exception.UserCustomException;
import com.emp.repo.EmployeeRepo;
import com.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo repo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public EmployeeDTO saveDetails(EmployeeDTO dto) {

		try {

			dto.setPassword(passwordEncoder.encode(dto.getPassword()));
			EmployeeEntity entity = entityToDTO(dto);
			repo.save(entity);
		}

		catch (Exception e) {
			// throw new UsernameNotFoundException("Exception Accured",e);
		}
		return dto;

	}

	@Override
	public EmployeeDTO updateDetails(EmployeeDTO dto) {

		try {
			EmployeeEntity entity = new EmployeeEntity();
			entity.setFristName(dto.getFristName());
			entity.setLastName(dto.getLastName());
			entity.setEmail(dto.getEmail());
			entity.setPassword(dto.getPassword());
			entity.setSalary(dto.getSalary());
			entity.setDepartment(dto.getDepartment());
			repo.save(entity);

		} catch (Exception e) {
			// TODO: handle exception

		}
		return dto;

	}

	@Override
	public EmployeeEntity getEmployee(Long id) {

		return repo.findById(id).get();
	}

//	@Override
//	public EmployeeEntity saveDetails(EmployeeEntity entity) {
//		
//		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
//			
//			return repo.save(entity);
//
//			
//		
//	}
//
//	@Override
//	public EmployeeEntity updateDetails(EmployeeEntity entity, Long id) {
//		
//		
//		/*
//		 * EmployeeEntity emp=repo.findById(id).get(); if(emp.getId() !=0) {
//		 * emp.setFristName(entity.getFristName());
//		 * emp.setLastName(entity.getLastName()); emp.setEmail(entity.getEmail());
//		 * emp.setDepartment(entity.getDepartment());
//		 * 
//		 * }
//		 */
//		  return repo.save(entity);
//		 
//	
//
//		
//	}

	public EmployeeEntity getEmployee1(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public void deleteEmployee(Long id) {

		repo.deleteById(id);
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public EmployeeEntity findByFristnameAndLastname(String firstName, String lastName) {
		return repo.findByFristnameAndLastname(firstName, lastName);
	}

//convert to Entity to Dto

	public EmployeeEntity entityToDTO(EmployeeDTO dto) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setFristName(dto.getFristName());
		entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setDepartment(dto.getDepartment());
		entity.setSalary(dto.getSalary());
		return entity;

	}

	@Override
	public EmployeeDTO employeeLogin(EmployeeLoginDTO loginDTO) {

		if (loginDTO.getEmail() != null && !loginDTO.getEmail().isEmpty()) {
			EmployeeDTO dto = new EmployeeDTO();

			dto.setEmail(loginDTO.getEmail());
		}
		EmployeeEntity findByEmail = repo.findByEmailId(loginDTO.getEmail().toLowerCase());
		if (null != findByEmail) {
			//String securePassword = getSecurePassword(loginDTO.getPassword());

			if (findByEmail.getPassword().equals(loginDTO.getPassword())) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setId(findByEmail.getId());
				employeeDTO.setFristName(findByEmail.getFristName());
				employeeDTO.setLastName(findByEmail.getLastName());
				employeeDTO.setEmail(findByEmail.getEmail());
				employeeDTO.setPassword(findByEmail.getPassword());
				employeeDTO.setLoginAt(new Date());
				employeeDTO.setDepartment(findByEmail.getDepartment());
				// employeeDTO.setAction(null);
				return employeeDTO;
			} else {
				throw new UserCustomException("Please enter correct password");
			}

		} else {
			throw new UserCustomException("no such record found");
		}
		
		

	}

	@Override
	public String logout(EmployeeLogout logout) {
		
		EmployeeDTO dto=new EmployeeDTO();
		if(logout.getEmail().equals(dto.getEmail()) )
		{
			repo.deleteByEmailId(dto.getEmail());
		}
		
		
		return "Employee Logout Successfully";
	}

}
