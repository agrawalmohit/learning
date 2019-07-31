package com.threads;

import java.util.concurrent.CountDownLatch;

public class SumOfSquaresThread implements Runnable {

	private CountDownLatch countDown = null;
	private int[] array = null;

	public SumOfSquaresThread(CountDownLatch countDown, int[] arr) {
		this.countDown = countDown;
		this.array = arr;
	}

	@Override
	public void run() {

		int sumOfSquares = 0;
		synchronized (array) {
			for (int i = 0; i < array.length; i++)
				sumOfSquares = sumOfSquares + (array[i] * array[i]);
		}
		System.out.println("Sum of squares of elements: " + sumOfSquares);
		countDown.countDown();

	}

}
