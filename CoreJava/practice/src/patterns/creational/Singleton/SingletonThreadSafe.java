package patterns.creational.Singleton;

public class SingletonThreadSafe {

	private SingletonThreadSafe() {
	}

	private static SingletonThreadSafe instance;

	public synchronized static SingletonThreadSafe getInstance() {
		if (instance == null) {
			instance = new SingletonThreadSafe();
		}
		return instance;
	}
}
