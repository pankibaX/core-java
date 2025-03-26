package com.pankiba.generics.boundedwildcards;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.pankiba.util.ApplicationUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PlayWithLowerBoundedWildCard {

	public static void main(String[] args) {

		ApplicationUtils.logHeader("PlayWithLowerBoundedWildCard");
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		numsUpTo(5, integerList);

		ArrayList<Number> numberList = new ArrayList<Number>();
		numsUpTo(5, numberList);

	}

	/**
	 * Use super when you want to add values to collection
	 * 
	 * ? super Number Integer to "any type that is an Integer type or its super type"
	 */
	public static void numsUpTo(Integer number, List<? super Integer> list) {

		IntStream.rangeClosed(1, number).forEach(list::add);

		log.info(" {} ", list);

	}
}
