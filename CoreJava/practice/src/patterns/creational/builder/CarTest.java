package patterns.creational.builder;

public class CarTest {

	public static void main(String[] args) {
		Car car = Car.newBuilder().setColor("green").setFuelType("petrol").setTransmission("automatic")
				.build();
		System.out.println(car);
	}

}
