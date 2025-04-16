package com.pankiba.codechallenge;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

public class Java8Challenge {

	public static void main(String[] args) {

		// Find out the count of male and female employees present in the organization

		// Write a program to print the names of all departments in the organization.

		// Find the average age of Male and Female Employees.

		// Get the Names of employees who joined after 2015.

		// Count the number of employees in each grade.

		// Find out the average salary of each grade

		// Find out the oldest employee, his/her age and department ?

		// Find out the average and total salary of the organization.

		LongSummaryStatistics longSummaryStatistics = ApplicationUtils.getTestData().stream()
				.mapToLong(emp -> emp.getSalary()).summaryStatistics();

		// List down the employees of each grade.

		// Find out the highest experienced employees in the organization

//		System.out.println(groupByExperienceBands(ApplicationUtils.getTestData()));

		ApplicationUtils.getTestData().stream().forEach(emp -> {
			System.out.println(emp.getJoiningDate());
		});

		System.out.println(findEmployeeWithMaxExperience(ApplicationUtils.getTestData()));

	}

	public static Employee findEmployeeWithMaxExperience(List<Employee> employees) {

		employees.stream().max((e1, e2) -> e1.getJoiningDate().compareTo(e2.getJoiningDate()));

		return employees.stream().min(Comparator.comparing(Employee::getJoiningDate)).orElse(null);
	}

	public static Map<String, List<Employee>> groupByExperienceBands(List<Employee> employees) {
		return employees.stream().collect(Collectors.groupingBy(emp -> {

			if (emp.getJoiningDate() == null)
				return "No Joining Date";

			long years = ChronoUnit.YEARS.between(
					emp.getJoiningDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now());

			if (years < 1)
				return "Less than 1 year";
			if (years <= 3)
				return "1-3 years";
			if (years <= 5)
				return "3-5 years";
			return "5+ years";
		}));
	}
}
