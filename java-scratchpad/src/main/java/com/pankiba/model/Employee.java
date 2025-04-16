package com.pankiba.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

	private static final long serialVersionUID = 6798516679232905689L;

	private Long employeeId;

	private String firstName;

	private String lastName;

	private String gender;

	private String email;

	private Date birthDate;

	private Date joiningDate;

	private String grade;

	private Long salary;
	
	private String department;
	
	private List<String> skills;
	
	@Override
	public String toString() {
		return employeeId + " - " + firstName + " " + lastName + " - " + gender + " - " + grade + " - " + salary + " - "+department;
	}
}
