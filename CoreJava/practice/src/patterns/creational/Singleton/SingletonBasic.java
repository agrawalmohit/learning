package patterns.creational.Singleton;

public class SingletonBasic {

	private SingletonBasic() {
	}

	private static final SingletonBasic INSTANCE = new SingletonBasic();

	public static SingletonBasic getInstance() {
		return INSTANCE;
	}

}
