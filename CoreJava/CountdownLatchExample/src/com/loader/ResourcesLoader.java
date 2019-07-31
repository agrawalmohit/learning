package com.loader;

import java.util.concurrent.CountDownLatch;

public class ResourcesLoader extends Services {
	private CountDownLatch countdown;
	private String service;

	public ResourcesLoader(CountDownLatch countdown, String service) {

		this.countdown = countdown;
		this.service = service;
	}

	@Override
	public void run() {
		System.out.println(service + " loaded");
		countdown.countDown();

	}
}
