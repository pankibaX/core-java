package com.pankiba.codechallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * 
 * 1+5+9 = 15 & 4+5+7 = 16 then 16-15
 * 
 */
public class DiagonalDifference {

	public static int diagonalDifference(List<List<Integer>> nestedList) {

		int leftSum = 0, rightSum = 0;
		/*
		 * leftsum calculated using 00, 11, 22 rightsum calculated using 0(size-(row+1))=02 1(size-(row+1))=11
		 * 2(size-(row+1))=20 which is 02 11 20
		 */
		for (int i = 0; i < nestedList.size(); i++) {
			leftSum += nestedList.get(i).get(i);
			rightSum += nestedList.get(i).get(nestedList.size() - (i + 1));
		}
		return Math.abs(rightSum - leftSum);
	}

	public static void main(String[] args) {

		List<Integer> listOne = Arrays.asList(1, 2, 3);
		List<Integer> listTwo = Arrays.asList(4, 5, 6);
		List<Integer> listThree = Arrays.asList(9, 8, 9);

		List<List<Integer>> nestedList = new ArrayList<List<Integer>>();
		nestedList.add(listOne);
		nestedList.add(listTwo);
		nestedList.add(listThree);

		System.out.println(" Difference is " + DiagonalDifference.diagonalDifference(nestedList));

	}
}
