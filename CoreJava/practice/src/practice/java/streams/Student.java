package practice.java.streams;

import java.util.List;

class Student {

	private int num;
	private String name;
	private List<Integer> mobiles;
	private Address address;

	public Student(int num, String name, List<Integer> mobiles, Address address) {
		this.num = num;
		this.name = name;
		this.mobiles = mobiles;
		this.address = address;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getMobiles() {
		return mobiles;
	}

	public void setMobiles(List<Integer> mobiles) {
		this.mobiles = mobiles;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", mobiles=" + mobiles + ", address=" + address + "]";
	}

	
}

