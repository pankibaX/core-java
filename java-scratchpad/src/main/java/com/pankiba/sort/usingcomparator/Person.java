package com.pankiba.sort.usingcomparator;

public class Person {

	private String name;
	private Integer age;

	Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	String getName() {
		return name;
	}

	Integer getAge() {
		return age;
	}

	@Override
	public String toString() {
		return this.name + ":" + this.age;
	}

}