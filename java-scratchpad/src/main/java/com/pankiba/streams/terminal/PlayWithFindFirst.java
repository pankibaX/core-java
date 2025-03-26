package com.pankiba.streams.terminal;

import java.util.List;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

public class PlayWithFindFirst {
	public static void main(String[] args) {

		List<Employee> employeeList = ApplicationUtils.getTestData();

		ApplicationUtils.logHeader("findFirst - lambda");
		Employee emp = employeeList.stream().filter(employee -> employee.getSalary() > 20000L).findFirst().orElse(null);

		System.out.println(emp);

	}
}
