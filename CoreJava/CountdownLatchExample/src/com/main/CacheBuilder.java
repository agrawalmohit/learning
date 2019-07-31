package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.loader.PropertiesLoader;
import com.loader.ResourcesLoader;
import com.loader.Services;

public class CacheBuilder {

	private static CountDownLatch makeResourcesReady;

	public static void main(String[] args) throws InterruptedException {
		makeResourcesReady = new CountDownLatch(2);
		Services resources = new ResourcesLoader(makeResourcesReady, "Database Resources");
		Services properties = new PropertiesLoader(makeResourcesReady, "Application Properties");
		List<Services> services = new ArrayList<Services>();
		services.add(resources);
		services.add(properties);
		Executor executor = Executors.newFixedThreadPool(services.size());
		for (Services service : services) {
			executor.execute(service);
		}
		makeResourcesReady.await();
		System.out.println("All the resources are ready. Creating cache from the loaded resources!");
	}

}
