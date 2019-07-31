package com.threads;

import java.util.concurrent.CountDownLatch;

public class SumThread implements Runnable {

	private CountDownLatch countDown = null;
	private int[] array = null;

	public SumThread(CountDownLatch countDown, int[] arr) {
		this.countDown = countDown;
		this.array = arr;
	}

	@Override
	public void run() {
		int sum = 0;
		synchronized (array) {

			for (int i = 0; i < array.length; i++) {
				sum = sum + array[i];
			}

		}
		System.out.println("Sum of elements: " + sum);
		countDown.countDown();
	}

}
