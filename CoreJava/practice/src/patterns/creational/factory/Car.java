package patterns.creational.factory;

public abstract class Car {

	protected Colors color;
	protected FuelType fuelType;
	protected Transmission transmission;

	public Car(Colors color, FuelType fuelType, Transmission transmission) {
		this.color = color;
		this.fuelType = fuelType;
		this.transmission = transmission;
	}

	public abstract Colors getColor();

	public abstract FuelType getFueltype();

	public abstract Transmission getTransmission();
}
