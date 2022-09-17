package patterns.creational.factory;

public class HyundaiVenue extends Car {

	public HyundaiVenue(Colors color, FuelType fuelType, Transmission transmission) {
		super(color, fuelType, transmission);
	}

	@Override
	public Colors getColor() {
		return this.color;
	}

	@Override
	public FuelType getFueltype() {
		return this.fuelType;
	}

	@Override
	public Transmission getTransmission() {
		return this.transmission;
	}

}
