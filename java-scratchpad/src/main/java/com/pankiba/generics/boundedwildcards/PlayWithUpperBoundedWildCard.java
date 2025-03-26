package com.pankiba.generics.boundedwildcards;

import java.util.Arrays;
import java.util.List;

import com.pankiba.util.ApplicationUtils;

public class PlayWithUpperBoundedWildCard {

	public static void main(String[] args) {

		ApplicationUtils.logHeader("Print integerList and sum of all the no's in it");
		List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
		sumOfList(integerList);

		ApplicationUtils.logHeader("Print doubleList and sum of all the no's in it");
		List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
		sumOfList(doubleList);

	}

	/**
	 * Use extends when you only get values out of data structure
	 * 
	 * An upper bounded wild card uses the extends keyword to set a superclass limit. For example, to define a list of
	 * numbers that will allow int's, long's, double's, and even BigDecimal instances to be added to it
	 * 
	 * ? extends Number translates to "any type that is an Number type or its sub type"
	 */

	public static void sumOfList(List<? extends Number> list) {
		// print the list and sum of all no's in it
		double totalOfList = list.stream().mapToDouble(number -> number.doubleValue())
				.peek(number -> System.out.println(number)).sum();
		System.out.println("sum : " + totalOfList);
	}
}
