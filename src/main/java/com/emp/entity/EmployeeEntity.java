package com.emp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table(name = "employee")
@Data
@Entity
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private long Id;

	
	
	@NotEmpty
	@Size(min = 3,message = "FristName Should be atleast 3 Characters")
	@Column(name = "fristName")
	private String fristName;

	
	@NotEmpty
	@Size(min = 3,message = "lastName Should be atleast 3 Characters")
	@Column(name = "lastName")
	private String lastName;

	@Column(name = "email")
	private String email;

	@NotEmpty
	@Size(min=3,message = "Department Should be atleast 3 Characters")
	@Column(name = "deparment")
	private String department;

	
        @NotEmpty
	@Size(min=3,message = "Action Should be atleast 3 Characters")
	@Column(name = "action")
	private String action;

	
	@Column(name = "salary")
	private long salary;
	
	@Column(name="password")
	private String password;

	
	

}
