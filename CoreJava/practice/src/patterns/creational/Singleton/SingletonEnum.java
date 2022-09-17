package patterns.creational.Singleton;

public enum SingletonEnum {

	INSTANCE;

	public void printMe() {
		System.out.println("i am sigleton " + INSTANCE);
	}
}
