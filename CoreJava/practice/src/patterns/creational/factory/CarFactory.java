package patterns.creational.factory;

public class CarFactory {

	private CarFactory() {
	}

	public static final CarFactory FACTORY() {
		return InnerCarFactory.INSTANCE;
	}

	private static class InnerCarFactory {
		private static final CarFactory INSTANCE = new CarFactory();
	}

	public static Car getCar(String carName, Colors color, FuelType fuelType, Transmission transmission) {
		if (carName.equals("HyundaiVenue")) {
			return new HyundaiVenue(color, fuelType, transmission);
		}
		if (carName.equals("ToyotaInnova")) {
			return new ToyotaInnova(color, fuelType, transmission);
		}
		return null;
	}

}
