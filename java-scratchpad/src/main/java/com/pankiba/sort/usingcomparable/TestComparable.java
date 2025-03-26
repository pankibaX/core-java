package com.pankiba.sort.usingcomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparable {
	public static void main(String[] args) {

		List<Person> personList = new ArrayList<Person>();

		personList.add(new Person("John", 34));
		personList.add(new Person("Tom", 42));
		personList.add(new Person("Bond", 28));

		System.out.println("*** Before Sort ***");
		System.out.println(personList);

		Collections.sort(personList);

		System.out.println("*** After Sort ***");
		System.out.println(personList);

	}
}
