package com.grpc.server.streaming.client;

import java.util.Iterator;

import com.example.server.Information;
import com.example.server.Number;
import com.example.server.ServerStreamingGrpc;
import com.example.server.ServerStreamingGrpc.ServerStreamingBlockingStub;
import com.grpc.server.streaming.server.StreamingService;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Data 
{
	public static void main(String[] args) 
	{
		String address="localhost";
		int portNumber=8085;
		int n=5;
		ManagedChannel channel=ManagedChannelBuilder
				.forAddress(address, portNumber)
				.usePlaintext()
				.build();
		Number  number=Number.newBuilder()
				.setNumber(n)
				.build();
		ServerStreamingBlockingStub blockingStub=ServerStreamingGrpc
				.newBlockingStub(channel);
		
		Iterator<Information> information=blockingStub.getMessage(number);
		while (information.hasNext()) {
			System.out.println(information.next());
			
		}		
		
		
		
	}

}
