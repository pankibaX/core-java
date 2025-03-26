package com.pankiba.streams.terminal;

import java.util.List;
import java.util.LongSummaryStatistics;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

public class PlayWithStatistics {

	public static void main(String[] args) {

		List<Employee> employeeList = ApplicationUtils.getTestData();

		LongSummaryStatistics longSummaryStatistics = employeeList.stream().mapToLong(emp -> emp.getSalary())
				.summaryStatistics();

		System.out.println(longSummaryStatistics);

	}
}
