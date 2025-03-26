package com.pankiba.generics;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayWithGenericMethod {

	public static void main(String[] args) {

		Integer[] intArray = { 1, 2, 3, 4, 5 };
		Double[] doubleArray = { 1.1, 1.2, 1.3, 1.4, 1.5 };
		Character[] charArray = { 'B', 'A', 'R', 'V', 'E', 'P', 'A', 'N' };

		log.info(" Integer Array contains ");
		printArray(intArray);

		log.info(" Double Array contains ");
		printArray(doubleArray);

		log.info(" Character Array contains ");
		printArray(charArray);

	}

	public static <E> void printArray(E[] inputArray) {
		for (E element : inputArray) {
			log.info("{}", element);
		}
	}

}
