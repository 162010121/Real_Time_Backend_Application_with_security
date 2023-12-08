package com.emp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.emp.dto.EmployeeDTO;
import com.emp.entity.EmployeeEntity;
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
			return dto;
		} catch (Exception e) {
			throw new UsernameNotFoundException("Exception Accured",e);
		}

	}

	@Override
	public EmployeeDTO updateDetails(EmployeeDTO dto) {

		try {
			EmployeeEntity entity=new EmployeeEntity();
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
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void deleteEmployee(Long id) {

		repo.deleteById(id);
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public EmployeeEntity findByFristnameAndLastname(String firstName, String lastName) {
		// TODO Auto-generated method stub
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

}
