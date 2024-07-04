package com.ayush.chatapp.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.ayush.chatapp.utils.ConfigReader;

public class Server {

	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers = new ArrayList<>();   //Contains all the client sockets
	/* Multiple CLient*/
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server Start and Waiting for the clients to join...");
		handleClientRequest();
		
	}
	//Multiple Client HandShaking
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket = serverSocket.accept();   //handShaking process
			//per Client Per Thread
			ServerWorker serverWorker = new ServerWorker(clientSocket,this);   //Creating a New Worker/Thread
			workers.add(serverWorker);
			serverWorker.start();
			}
	}
	
	
	/*single Client*/
	/*
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server Started and Waiting for the Client Connection....");
		Socket socket = serverSocket.accept();   //handShaking process
		System.out.println("Client Joins the Server..");
		InputStream in = socket.getInputStream();    //read bytes from the network
		byte arr[] = in.readAllBytes();
		String str = new String(arr);   //Bytes convert into string
		System.out.println("Message Received from the client "+str);
		in.close();
		socket.close();
	}
	*/
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		Server server = new Server();
		

	}

}
