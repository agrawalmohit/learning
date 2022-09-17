package patterns.creational.Singleton;

public class SingletonStatic {

	private SingletonStatic() {
	}

	static {
		INSTANCE = new SingletonStatic();
	}
	private static final SingletonStatic INSTANCE;

	public static SingletonStatic getInstance() {
		return INSTANCE;
	}
}
