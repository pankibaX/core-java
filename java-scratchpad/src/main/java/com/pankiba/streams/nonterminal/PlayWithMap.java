package com.pankiba.streams.nonterminal;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

public class PlayWithMap {

	public static void main(String[] args) {

		List<Employee> employeeList = ApplicationUtils.getTestData();

		ApplicationUtils.logHeader("map - traditional");
		// Using map function create list of employee names
		employeeList.stream().map(new MyFunction()).collect(Collectors.toList()).forEach(new StringConsumer());

		ApplicationUtils.logHeader("map - lambda expression");
		employeeList.stream().map(Employee::getFirstName).collect(Collectors.toList()).forEach(System.out::println);

		ApplicationUtils.logHeader("map - lambda expression");
		employeeList.stream().map(Employee::getSalary).collect(Collectors.toList()).forEach(System.out::println);

		ApplicationUtils.logHeader("map - lambda expression");
		Long sum = employeeList.stream().mapToLong(Employee::getSalary).sum();
		System.out.println("sum of all salaries : " + sum);
	}
}

class MyFunction implements Function<Employee, String> {

	@Override
	public String apply(Employee employee) {
		return employee.getFirstName();
	}
}

class StringConsumer implements Consumer<String> {

	@Override
	public void accept(String str) {
		System.out.println(str);
	}
}