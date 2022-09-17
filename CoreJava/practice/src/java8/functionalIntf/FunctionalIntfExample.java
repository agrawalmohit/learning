package java8.functionalIntf;

public class FunctionalIntfExample {

	public static void main(String[] args) {
		// old way to initialize. anonymous class
		new Test(new FunctionalIntf1() {

			@Override
			public void process(String val) {
				System.out.println("oldway: " + val);

			}
		}).print();

		// using lambda
		new Test((x) -> {
			System.out.println("New way using lambda: " + x);
		}).print();
	}

}

interface FunctionalIntf1 {
	public void process(String val);
}

class Test {

	FunctionalIntf1 intf;

	public Test(FunctionalIntf1 intf) {
		this.intf = intf;
	}

	public void print() {
		intf.process("hello");
	}
}
