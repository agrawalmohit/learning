package com.grpc.client;

import com.grpc.grpcService.EmployeeRequest;
import com.grpc.grpcService.EmployeeResponse;
import com.grpc.grpcService.EmployeeServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class AppClient {

	public static void main(String[] args) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090).usePlaintext().build();
		EmployeeServiceGrpc.EmployeeServiceBlockingStub employeeStub = EmployeeServiceGrpc.newBlockingStub(channel);
		EmployeeResponse empResponse = employeeStub.getEmployee(EmployeeRequest.newBuilder().setFirstName("Mohit").setLastName("Agarwal").build());
		System.out.println("Response from server: "+empResponse);
		channel.shutdown();
	}
}
