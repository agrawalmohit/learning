package java8.functionalIntf;

import java.util.Optional;

public class OptionalClass {

	public static void main(String[] args) {
		Optional<String> opt = Optional.empty();
		System.out.println(opt.isEmpty());
		System.out.println(opt.isPresent());
	}
}
