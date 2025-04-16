package com.pankiba.streams;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

import com.pankiba.model.Employee;
import com.pankiba.util.ApplicationUtils;

public class StreamOperations {

	public static void main(String[] args) {

		List<Employee> employees = ApplicationUtils.getTestData();

		// 1. Filtering operations
		filterOperations(employees);

		// 2. Mapping operations
		mapOperations(employees);

		// 3. Sorting operations
		sortingOperations(employees);

		// 4. Aggregation operations
		aggregationOperations(employees);

		// 5. Grouping operations
		groupingOperations(employees);

		// 6. Matching operations
		matchingOperations(employees);

		// 7. Finding operations
		findingOperations(employees);

		// 8. Reduction operations
		reductionOperations(employees);

		// 9. Parallel stream operations
		parallelStreamOperations(employees);

		// 10. Specialized operations
		specializedOperations(employees);
	}

	private static void filterOperations(List<Employee> employees) {

		// Filter employees with salary > 50000
		List<Employee> highSalaryEmployees = employees.stream().filter(e -> e.getSalary() > 50000)
				.collect(Collectors.toList());

		// Filter employees in specific department
		List<Employee> deptEmployees = employees.stream().filter(e -> "IT".equals(e.getDepartment()))
				.collect(Collectors.toList());

		// Distinct departments
		List<String> distinctDepts = employees.stream().map(Employee::getDepartment).distinct()
				.collect(Collectors.toList());
	}

	private static void mapOperations(List<Employee> employees) {

		// Get list of employee names
		List<String> employeeNames = employees.stream().map(Employee::getFirstName).collect(Collectors.toList());

		// Get employee IDs
		List<Long> employeeIds = employees.stream().map(Employee::getEmployeeId).collect(Collectors.toList());

		// Transform to DTOs or other objects
		List<EmployeeDTO> employeeDTOs = employees.stream()
				.map(e -> new EmployeeDTO(e.getEmployeeId(), e.getFirstName())).collect(Collectors.toList());
	}

	private static void sortingOperations(List<Employee> employees) {

		// Sort by name. Following will first create the comparator and then sort. which
		List<Employee> sortedByName = employees.stream().sorted(Comparator.comparing(Employee::getFirstName))
				.collect(Collectors.toList());

		// Sort by salary descending
		List<Employee> sortedBySalaryDesc = employees.stream()
				.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());

		// Sort by department then by name
		List<Employee> sortedByDeptThenName = employees.stream()
				.sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getFirstName))
				.collect(Collectors.toList());
	}

	private static void aggregationOperations(List<Employee> employees) {

		// Count employees in IT department
		long itEmployeeCount = employees.stream().filter(e -> "IT".equals(e.getDepartment())).count();

		// Max salary
		Optional<Employee> maxSalaryEmployee = employees.stream().max(Comparator.comparingDouble(Employee::getSalary));

		// Min salary
		Optional<Employee> minSalaryEmployee = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));

		// Average salary
		OptionalDouble averageSalary = employees.stream().mapToDouble(Employee::getSalary).average();

		// Sum of all salaries
		double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
	}

	private static void groupingOperations(List<Employee> employees) {

		// Group by department
		Map<String, List<Employee>> employeesByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));

		// Group by department with count
		Map<String, Long> employeeCountByDept = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		// Group by department with average salary
		Map<String, Double> avgSalaryByDept = employees.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		// Partitioning (e.g., high salary vs low salary)
		Map<Boolean, List<Employee>> partitionedEmployees = employees.stream()
				.collect(Collectors.partitioningBy(e -> e.getSalary() > 50000));
	}

	private static void matchingOperations(List<Employee> employees) {

		// Check if all employees have salary > 30000
		boolean allMatch = employees.stream().allMatch(e -> e.getSalary() > 30000);

		// Check if any employee has salary > 100000
		boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 100000);

		// Check if no employee is in HR department
		boolean noneMatch = employees.stream().noneMatch(e -> "HR".equals(e.getDepartment()));
	}

	private static void findingOperations(List<Employee> employees) {
		// Find first employee in IT department
		Optional<Employee> firstITEmployee = employees.stream().filter(e -> "IT".equals(e.getDepartment())).findFirst();

		// Find any employee in Finance department
		Optional<Employee> anyFinanceEmployee = employees.stream().filter(e -> "Finance".equals(e.getDepartment()))
				.findAny();
	}

	private static void reductionOperations(List<Employee> employees) {

		// Concatenate all employee names
		String allNames = employees.stream().map(Employee::getFirstName).reduce("", (a, b) -> a + ", " + b);

		// Sum of salaries using reduce
		Long totalSalary = employees.stream().map(Employee::getSalary).reduce(0L, Long::sum);

		// Highest salary using reduce
		Optional<Long> maxSalary = employees.stream().map(Employee::getSalary).reduce(Long::max);
	}

	private static void parallelStreamOperations(List<Employee> employees) {
		// Process in parallel
		List<String> parallelNames = employees.parallelStream().map(Employee::getFirstName)
				.collect(Collectors.toList());

		// Parallel processing with grouping
		Map<String, List<Employee>> parallelGrouping = employees.parallelStream()
				.collect(Collectors.groupingByConcurrent(Employee::getDepartment));
	}

	private static void specializedOperations(List<Employee> employees) {

		// FlatMap example (if Employee has nested collections)
		List<String> allSkills = employees.stream().flatMap(e -> e.getSkills().stream()).collect(Collectors.toList());

		// Peek for debugging
		List<Employee> processedEmployees = employees.stream()
				.peek(e -> System.out.println("Processing: " + e.getFirstName())).filter(e -> e.getSalary() > 40000)
				.peek(e -> System.out.println("After filter: " + e.getFirstName())).collect(Collectors.toList());

		// Skip and limit
		List<Employee> paginatedEmployees = employees.stream().skip(10).limit(5).collect(Collectors.toList());

		// Collecting to other collections
		Set<String> employeeNameSet = employees.stream().map(Employee::getFirstName).collect(Collectors.toSet());

		// Joining strings
		String allNamesJoined = employees.stream().map(Employee::getFirstName).collect(Collectors.joining(", "));

		// Summary statistics
		DoubleSummaryStatistics stats = employees.stream().mapToDouble(Employee::getSalary).summaryStatistics();
	}

	// Example DTO class for mapping demonstration
	record EmployeeDTO(Long id, String name) {}
}