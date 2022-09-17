
public class SinglenExample {
	
	private SinglenExample() {}
	
	private static final SinglenExample INSTANCE = new SinglenExample();
	
	public static SinglenExample getInstance() {
		return INSTANCE;
	}
	

}
