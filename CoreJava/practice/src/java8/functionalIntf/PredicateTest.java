package java8.functionalIntf;

import java.util.function.Predicate;

public class PredicateTest {

	public static void main(String[] args) {
		Predicate<Integer> equalPred = e -> e == 10;
		System.out.println(equalPred.and(x -> x < 100).or(x -> x != -1).test(100));
		System.out.println(equalPred.test(10));
	}
}
