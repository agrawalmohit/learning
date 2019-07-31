package com.loader;

import java.util.concurrent.CountDownLatch;

public class PropertiesLoader extends Services {

	private CountDownLatch countdown;
	private String service;

	public PropertiesLoader(CountDownLatch countdown, String service) {

		this.countdown = countdown;
		this.service = service;
	}

	@Override
	public void run() {
		System.out.println(service + " loaded");
		countdown.countDown();

	}

}
