package patterns.creational.builder;

public class Car {

	private String color;
	private String transmission;
	private String fuelType;

	private Car() {
	}

	private Car(CarBuilder builder) {
		this.color = builder.color;
		this.transmission = builder.transmission;
		this.fuelType = builder.fuelType;
	}

	public String getColor() {
		return this.color;
	}

	public String getTransmission() {
		return this.transmission;
	}

	public String getFuelType() {
		return this.fuelType;
	}
	
	public static CarBuilder newBuilder() {
		return new CarBuilder();
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", transmission=" + transmission + ", fuelType=" + fuelType + "]";
	}

	public static class CarBuilder {
		private String color;
		private String transmission;
		private String fuelType;

		public Car build() {
			return new Car(this);
		}

		public CarBuilder setColor(String color) {
			this.color = color;
			return this;
		}

		public CarBuilder setTransmission(String transmission) {
			this.transmission = transmission;
			return this;
		}

		public CarBuilder setFuelType(String fuelType) {
			this.fuelType = fuelType;
			return this;
		}
	}

}
