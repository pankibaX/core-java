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
		System.out.println("\n" + buf.replace(start, start + logMessage.length(), " " + logMessage + " ") + "\n");

	}

}
