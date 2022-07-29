package com.ace.ds;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	@Size(min = 2, max = 5, message = "Code must have length of 2 - 5 characters")
	@Pattern(regexp = "[A-Za-z-']*", message = "Code contains illegal characters")
	private String code;
	@NotBlank
	@Pattern(regexp = "[A-Za-z-']*", message = "Course Name contains illegal characters")
	private String name;
	@NotBlank
	@Pattern(regexp = "[0-9]{3}", message = "Fees contains illegal character")
	private double fees;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	
}
