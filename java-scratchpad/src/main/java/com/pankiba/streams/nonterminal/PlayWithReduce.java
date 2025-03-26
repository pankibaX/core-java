package com.pankiba.streams.nonterminal;

import java.util.List;
import java.util.function.BinaryOperator;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

public class PlayWithReduce {

	public static void main(String[] args) {

		List<Employee> employeeList = ApplicationUtils.getTestData();

		System.out.println("sum of salaries of all employees - using reduce on streams");

		Long totalSalary = employeeList.stream().map(employee -> employee.getSalary())
				.peek(employe -> System.out.println(employe)).reduce((sal1, sal2) -> sal1 + sal2).get();

		System.out.println(" total salary is : " + totalSalary);

		System.out.println("sum of salaries of all employees - using sum on long streams");

		Long totalSalary1 = employeeList.stream().map(employee -> employee.getSalary()).mapToLong(Long::longValue)
				.sum();

		System.out.println(" total salary is : " + totalSalary1);

	}
}

class MyBinaryOperator implements BinaryOperator<Integer> {

	@Override
	public Integer apply(Integer t, Integer u) {
		return t + u;
	}

}