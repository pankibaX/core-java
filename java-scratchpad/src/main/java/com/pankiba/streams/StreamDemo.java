package com.pankiba.streams;

import java.util.Arrays;
import java.util.List;

public class StreamDemo {

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(1, 2, 4, 5, 6);

		intList.stream().map(n -> n * 2).peek(System.out::println).filter(n -> n > 10).toList();

	}
}
