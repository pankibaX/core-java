package com.pankiba.hashcodeequals;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.time.DateUtils;

import com.pankiba.model.Employee;

import lombok.extern.slf4j.Slf4j;

/**
 * If two objects are equal, then they must have the same hashcode. If two
 * objects have the same hashcode then they may or may not be equal.
 *
 */
@Slf4j
public class PlayWithHashCodeEquals {

	public static void main(String[] args) throws ParseException {

		Set<Employee> employeeSet = new HashSet<Employee>();

		/**
		 * creating employee object and adding to HashSet. Below add statement will fist
		 * called hashCode method defined in Employee class. If not explicitly defined
		 * then it will use default implementation from Object class
		 */

		employeeSet.add(new Employee(677509L, "John", "Rambo", "M", "john.rambo@users.noreply.github.com",
				DateUtils.parseDate("03/29/1987", "MM/dd/yyyy"), DateUtils.parseDate("11/24/2003", "MM/dd/yyyy"),
				"Developer", 168251L, "HR", List.of("Java", "Spring", "Hibernate", "SQL")));

		/**
		 * below add statement will first call hashCode method, internally HashSet will
		 * find out that same hashCode is already taken then equals method define in
		 * Employee class will be called, if that returns true then value will be
		 * overwritten. Finally hashSet size will be 1.
		 */

		employeeSet.add(new Employee(677509L, "John", "Rambo", "M", "john.rambo@users.noreply.github.com",
				DateUtils.parseDate("03/29/1987", "MM/dd/yyyy"), DateUtils.parseDate("11/24/2003", "MM/dd/yyyy"),
				"Developer", 168251L, "IT", List.of("Java", "Python", "Hibernate", "SQL")));

		log.info(" Size of HashSet is {} ", employeeSet.size());
	}

}
