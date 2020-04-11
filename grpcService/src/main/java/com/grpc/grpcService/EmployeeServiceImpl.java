package com.grpc.grpcService;

public class EmployeeServiceImpl extends EmployeeServiceGrpc.EmployeeServiceImplBase{
	
	@Override
	public void getEmployee(com.grpc.grpcService.EmployeeRequest request,
	        io.grpc.stub.StreamObserver<com.grpc.grpcService.EmployeeResponse> responseObserver) {
		String response = new StringBuilder().append(request.getFirstName()).append(" ").append(request.getLastName()).append(" is present").toString();
		EmployeeResponse empResponse = EmployeeResponse.newBuilder().setIsExistMessage(response).build();
		responseObserver.onNext(empResponse);
		responseObserver.onCompleted();
	}

}
