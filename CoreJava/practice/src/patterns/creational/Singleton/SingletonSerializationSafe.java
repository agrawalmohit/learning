package patterns.creational.Singleton;

import java.io.Serializable;

public class SingletonSerializationSafe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 43391168526013100L;

	private SingletonSerializationSafe() {
	}

	private static final SingletonSerializationSafe INSTANCE = new SingletonSerializationSafe();

	protected Object readResolve() {
		return INSTANCE;
	}

}
