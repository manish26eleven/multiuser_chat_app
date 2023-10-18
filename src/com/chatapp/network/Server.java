package com.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.chatapp.others.configreader;


public  class Server {
	
  ServerSocket serverSocket;
  ArrayList<ServerWorker> workers = new ArrayList<>(); // contain all the sockets
  public Server() throws IOException {
	  
	  int PORT = Integer.parseInt(configreader.getvalue("PORTNO"));
	 // System.out.println(PORT);
	  serverSocket = new ServerSocket(PORT);
	  System.out.println("Server Started And Waiting for Client");
	  handleClientRequest();
	 
  }
  public void  handleClientRequest() throws IOException {
	  while(true) {
	  Socket clientsocket = serverSocket.accept();
	  ServerWorker serverworker = new ServerWorker(clientsocket,this);
	  workers.add(serverworker);
	  //System.out.println("Client Comes....");
	  serverworker.start();
	  }
  }
  /* for single client
  public Server() throws IOException  {
  int PORT = Integer.parseInt(configreader.getvalue("PORTNO"));
  System.out.println(PORT);
  serverSocket = new ServerSocket(PORT);
  System.out.println("Server started and waiting for client");
  Socket socket = serverSocket.accept();
  
  System.out.println("client joins");
  InputStream in = socket.getInputStream();
  byte arr[] = in.readAllBytes();
  String str = new String(arr);
  System.out.println("message received here -->> "+str);
  in.close();
  socket.close();
  }
  */
  public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        //System.out.println("hi");
	  Server Server = new Server();
	}
      
}
