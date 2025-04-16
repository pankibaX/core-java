package com.pankiba.util;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pankiba.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationUtils {

	private ApplicationUtils() {
	}

	public static List<Employee> getTestData() {

		ObjectMapper objectMapper = new ObjectMapper();

		try {

			List<Employee> employeeList = objectMapper.readValue(new File("test-data.json"),
					new TypeReference<List<Employee>>() {
					});

			return employeeList;

		} catch (Exception exception) {
			log.error("Error while loading data from josn file");
			exception.printStackTrace();
		}
		return null;
	}

	public static void logHeader(String logMessage) {
		String tempStr = "##########################################################################################################################################################";
		StringBuffer buf = new StringBuffer(tempStr);

		int start = 10;
		System.out.println("\n" + buf.replace(start, start + logMessage.length(), "" + logMessage + "") + "\n");

	}

	public static <T> void printListStats(List<T> list) {

		// Use StringBuilder for better performance with multiple concatenations
		StringBuilder sb = new StringBuilder();

		// Header
		sb.append("=== List Statistics ===\n").append("Size: ").append(list.size()).append("\n").append("Is empty: ")
				.append(list.isEmpty()).append("\n\n");

		// Elements section only if list is not empty
		if (!list.isEmpty()) {
			sb.append("Elements (").append(list.size()).append("):\n");
			for (int i = 0; i < list.size(); i++) {
				sb.append("[").append(i).append("] ").append(list.get(i)).append("\n");
			}
		} else {
			sb.append("No elements to display\n");
		}

		// Footer
		sb.append("======================");

		// Single print operation
		System.out.println(sb.toString());
	}

}
