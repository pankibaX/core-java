package com.pankiba.streams.nonterminal;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

public class PlayWithFilter {

	public static void main(String[] args) {

		List<Employee> employeeList = ApplicationUtils.getTestData();

		ApplicationUtils.logHeader("filter - traditional - all employees with grade developer");
		employeeList.stream().filter(new EmployeePredicate()).forEach(new EmpConsumer());

		ApplicationUtils.logHeader("filter - lambda expression - all employees with grade developer");
		employeeList.stream().filter(employee -> employee.getGrade().equals("Developer")).forEach(emp -> {
			System.out.println(emp);
		});

		ApplicationUtils.logHeader("filter - composed predicate - logical AND");

		Predicate<Employee> predicate1 = employee -> employee.getSalary() > 20000L;
		Predicate<Employee> predicate2 = employee -> employee.getGender().equals("F");

		employeeList.stream().filter(predicate1.and(predicate2)).forEach(emp -> {
			System.out.println(emp);
		});

		ApplicationUtils.logHeader("filter - composed predicate - logical OR");
		employeeList.stream().filter(predicate1.or(predicate2)).forEach(emp -> {
			System.out.println(emp);
		});

	}
}

class EmployeePredicate implements Predicate<Employee> {

	@Override
	public boolean test(Employee employee) {
		return employee.getGrade().equals("Developer");
	}
}

class EmpConsumer implements Consumer<Employee> {

	@Override
	public void accept(Employee employee) {
		System.out.println(employee);
	}
}
