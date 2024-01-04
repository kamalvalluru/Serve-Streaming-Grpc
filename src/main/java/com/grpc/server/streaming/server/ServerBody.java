package com.grpc.server.streaming.server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class ServerBody {
	public static void main(String[] args) {
		int portNumber = 8085;
		Server server = ServerBuilder.forPort(portNumber).addService(new StreamingService()).build();
		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Server is Stratred Successfully");

        // shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("gRPC server is shutting down!");
            server.shutdown();
        }));

		try {
			server.awaitTermination();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
