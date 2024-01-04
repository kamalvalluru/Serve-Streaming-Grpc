package com.grpc.server.streaming.server;

import com.example.server.Information;
import com.example.server.Number;
import com.example.server.ServerStreamingGrpc.ServerStreamingImplBase;

import io.grpc.stub.StreamObserver;

public class StreamingService extends ServerStreamingImplBase {

	@Override
	public void getMessage(Number request, StreamObserver<Information> responseObserver) {
		int n = request.getNumber();
		for (int i = 0; i < n; i++) {
			Information information = Information.newBuilder().setMessage("Hello World").build();
			responseObserver.onNext(information);
		}
		responseObserver.onCompleted();
	}

}
