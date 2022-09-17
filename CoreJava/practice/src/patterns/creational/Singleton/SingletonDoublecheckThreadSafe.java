package patterns.creational.Singleton;

public class SingletonDoublecheckThreadSafe {

	private SingletonDoublecheckThreadSafe() {
	}

	private static SingletonDoublecheckThreadSafe instance;

	public static SingletonDoublecheckThreadSafe getInstance() {
		if (instance == null) {
			synchronized (SingletonDoublecheckThreadSafe.class) {
				if (instance == null) {
					instance = new SingletonDoublecheckThreadSafe();
				}
			}
		}
		return instance;
	}
}
