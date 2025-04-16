package com.pankiba.sort.usingcomparator;

import java.util.Comparator;

import com.pankiba.model.Employee;

public class DateComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getJoiningDate().compareTo(o2.getJoiningDate());
	}



}
