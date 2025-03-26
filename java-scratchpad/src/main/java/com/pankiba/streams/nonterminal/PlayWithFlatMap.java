package com.pankiba.streams.nonterminal;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.pankiba.util.ApplicationUtils;

public class PlayWithFlatMap {
	public static void main(String[] args) {

		ApplicationUtils.logHeader("original nested list");

		List<List<String>> namesNested = Arrays.asList(Arrays.asList("John", "Rambo"), Arrays.asList("John", "McLane"),
				Arrays.asList("Ethan", "Hunt"));

		System.out.println(namesNested);

		ApplicationUtils.logHeader("flatMap - traditional");

		List<String> namesslatStream = namesNested.stream().flatMap(new MyFlatMapFunction())
				.collect(Collectors.toList());

		System.out.println(namesslatStream);

		ApplicationUtils.logHeader("flatMap - lambda");

		List<String> namesFlatStream = namesNested.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
		System.out.println(namesFlatStream);
		
	}
}

// (Function<? super T, ? extends Stream<? extends R>> mapper
class MyFlatMapFunction implements Function<List<String>, Stream<String>> {

	@Override
	public Stream<String> apply(List<String> strList) {
		return strList.stream();
	}

}