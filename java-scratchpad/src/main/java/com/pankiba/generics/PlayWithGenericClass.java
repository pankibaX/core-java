package com.pankiba.generics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayWithGenericClass {

	public static void main(String[] args) {

		// creating an instance of generic class
		Box<Integer> integerBox = new Box<Integer>();
		integerBox.add(10);

		log.info(" Integer Value {} ", integerBox.get());

		Box<String> stringBox = new Box<String>();
		stringBox.add("Hello World");

		log.info(" String Value {} ", stringBox.get());
	}
}

// We use <> to specify Parameter type
class Box<T> {

	private T t;

	public void add(T t) {
		this.t = t;
	}

	public T get() {
		return t;
	}
}