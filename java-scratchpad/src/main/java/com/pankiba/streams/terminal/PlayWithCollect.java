package com.pankiba.streams.terminal;

import java.util.List;
import java.util.stream.Collectors;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

public class PlayWithCollect {
	public static void main(String[] args) {

		List<Employee> employeeList = ApplicationUtils.getTestData();

		ApplicationUtils.logHeader("Obtain list of employees who are Developers");

		List<Employee> developerList = employeeList.stream()
				.filter(employee -> employee.getGrade().equals("Developer")).collect(Collectors.toList());

		developerList.forEach(dev -> System.out.println(dev));

	}
}
