package com.springboot_grpc.clients;

import org.springframework.stereotype.Component;

import com.grpc.grpcService.EmployeeRequest;
import com.grpc.grpcService.EmployeeResponse;
import com.grpc.grpcService.EmployeeServiceGrpc;
import com.grpc.grpcService.EmployeeServiceGrpc.EmployeeServiceBlockingStub;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

@Component
public class EmployeeClient {

	//private EmployeeServiceGrpc.EmployeeServiceBlockingStub employeeStub = null;

	/*
	 * private void generateClient() { ManagedChannel channel =
	 * ManagedChannelBuilder.forAddress("localhost", 8090).usePlaintext().build();
	 * EmployeeServiceGrpc.EmployeeServiceBlockingStub employeeStub =
	 * EmployeeServiceGrpc.newBlockingStub(channel); EmployeeResponse empResponse =
	 * employeeStub
	 * .getEmployee(EmployeeRequest.newBuilder().setFirstName("Mohit").setLastName(
	 * "Agarwal").build()); System.out.println("Response from server: " +
	 * empResponse); channel.shutdown(); }
	 */

	public String getEmployeeDetails(String fName, String lName) {
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8090).usePlaintext().build();
		EmployeeServiceGrpc.EmployeeServiceBlockingStub employeeStub = EmployeeServiceGrpc.newBlockingStub(channel);
		EmployeeResponse empResponse = employeeStub
				.getEmployee(EmployeeRequest.newBuilder().setFirstName(fName).setLastName(lName).build());
		return empResponse.toString();
	}
}
