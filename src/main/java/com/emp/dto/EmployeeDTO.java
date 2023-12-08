package com.emp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {
	
	private long Id;
	private String fristName;

	private String lastName;

	private String email;

	private String password;
	
	private String department;
	
	private long salary;

	private String action;

	


}
