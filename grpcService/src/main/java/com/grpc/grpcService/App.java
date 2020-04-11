package com.grpc.grpcService;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException, IOException {
		Server server = ServerBuilder.forPort(8090).addService(new EmployeeServiceImpl()).build();
		server.start();
		server.awaitTermination();
	}
}
