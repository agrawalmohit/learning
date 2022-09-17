package patterns.creational.Singleton;

/**
 * @author agraw
 *
 *         lazy initialized as Inner class will only load when accessed. can be
 *         broken via Reflection by changing constructor access to public.
 *         implement readResolve to prevent singleton when implementing
 */
public class SingletonBillPugh {

	private SingletonBillPugh() {

	}

	private static class Inner {
		private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
	}

	public static SingletonBillPugh getInstance() {
		return Inner.INSTANCE;
	}
}
