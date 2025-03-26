package com.pankiba.generics.boundedwildcards;

import java.util.Arrays;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayWithUnBoundedWildCard {

	public static void main(String[] args) {

		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		printList(integerList);

		List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
		printList(doubleList);

		List<String> stringList = Arrays.asList("One", "Two", "Three", "Four", "Five");
		printList(stringList);
	}

	private static void printList(List<?> list) {

	}
}
