/**
 * count and sum using java 8 reduce method
 */
package com.sn.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CountPlusSumUsingReduce {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(2,4,6,8,10);
		int count = numbers.stream().map(i->1).reduce(0, (a,b)->a+b);
		System.out.println(count);
		long sum = numbers.stream().reduce(0, (a,b)->a+b);
		System.out.println(sum);
		Optional<Integer> optSum = numbers.stream().reduce((a,b)->a+b);
		optSum.ifPresent(sum1->System.out.println(sum1));

	}

}
