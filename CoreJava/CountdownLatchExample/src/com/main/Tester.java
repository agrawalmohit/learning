package com.main;

import java.util.concurrent.CountDownLatch;

import com.threads.SumOfSquaresThread;
import com.threads.SumThread;

public class Tester {

	private static CountDownLatch countDown = new CountDownLatch(2);

	public static void main(String[] args) throws InterruptedException {

		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SumThread sum = new SumThread(countDown, array);
		SumOfSquaresThread squares = new SumOfSquaresThread(countDown, array);
		Thread t1 = new Thread(sum);
		Thread t2 = new Thread(squares);
		t1.start();
		t2.start();
		countDown.await();
		System.out.println("Sum and sum of squares is ready");

	}

}
