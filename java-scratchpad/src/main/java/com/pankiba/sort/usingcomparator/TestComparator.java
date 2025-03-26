package com.pankiba.sort.usingcomparator;

import java.util.ArrayList;
import java.util.Collections;

public class TestComparator {
	public static void main(String[] args) {

		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(new Person("Jack", 34));
		personList.add(new Person("Tom", 29));
		personList.add(new Person("Bond", 31));

		System.out.println("*** Sort Before using NameComparator***");
		System.out.println(personList);

		Collections.sort(personList, new NameComparator());

		System.out.println("*** Sort After using NameComparator***");
		System.out.println(personList);

		Collections.sort(personList, new AgeComparator());

		System.out.println("*** Sort After using AgeComparator***");
		System.out.println(personList);

	}
}
