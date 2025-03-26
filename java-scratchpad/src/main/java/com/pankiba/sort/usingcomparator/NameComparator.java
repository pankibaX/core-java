package com.pankiba.sort.usingcomparator;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

	/*
	 * sorts Person in ascending order for descending order use prsn2.compareTo(prsn1)
	 */
	@Override
	public int compare(Person prsn1, Person prsn2) {
		return prsn1.getName().compareTo(prsn2.getName());
	}

}
