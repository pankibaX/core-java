package com.pankiba.sort.usingcomparable;

public class Person implements Comparable<Person> {

	private String name;
	private int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	String getName() {
		return name;
	}

	int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return this.name + ":" + this.age;
	}

	/**
	 * This method takes a single argument which would be compared to this object and determines the sorting order based
	 * on the returned value of this function
	 * 
	 * This function compares this class object to person object passed as an argument and returns negative integer,
	 * zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Person object) {
		return (this.age < object.getAge()) ? -1 : (this.age == object.getAge()) ? 0 : 1;

	}
}