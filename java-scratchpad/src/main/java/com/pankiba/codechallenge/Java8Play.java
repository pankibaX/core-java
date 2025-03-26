package com.pankiba.codechallenge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Java8Play {
	public static void main(String[] args) {

		//The above example creates a stream of words.
		List<String> words = Arrays.asList("Modern", "Java", "In", "Action");

		Stream<Integer> intStream = words.stream().map(str -> str.length());
		
		Stream<String> ss = words.stream().flatMap(str -> Stream.of(str.split("")));
		

	}
}
