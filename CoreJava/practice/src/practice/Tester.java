package practice;

public class Tester {

	public static void main(String[] args) {

		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };

		ThreadClass thread = new ThreadClass(arr);
		OddThread oddThread = new OddThread(arr);
		thread.run();
		oddThread.run();
		thread.start();
	}
}

class ThreadClass extends Thread {

	int[] arr = null;

	public ThreadClass(int[] arr) {
		this.arr = arr;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println(i);
	}

	public synchronized void printEven() {

	}

}

class OddThread extends Thread {

	int[] arr = null;

	public OddThread(int[] arr) {
		this.arr = arr;
	}

	@Override
	public void run() {

	}

	public synchronized void printOdd() {

	}

}