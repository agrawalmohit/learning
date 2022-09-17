package practice.java.streams;

class Address {
	private String firstLine;
	private String secondLine;
	private int pin;

	public Address(String firstLine, String secondLine, int pin) {
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.pin = pin;
	}
	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Address [firstLine=" + firstLine + ", secondLine=" + secondLine + ", pin=" + pin + "]";
	}
	
	

}
