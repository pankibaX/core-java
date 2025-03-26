package com.pankiba.streams.terminal;

import java.util.List;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

public class PlayWithAnyMatch {
	public static void main(String[] args) {

		List<Employee> employeeList = ApplicationUtils.getTestData();

		ApplicationUtils.logHeader("anyMatch - lambda");
		boolean employeeMatch = employeeList.stream().anyMatch(employee -> employee.getSalary() > 20000L);

		System.out.println(" Employee found - " + employeeMatch);
	}
}
