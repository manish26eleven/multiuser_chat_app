package com.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.io.BufferedReader;

// thread -> worker
//worker need a job to perform 
//runnable will be given which will contain work logic 
//assign job to thread

public class ServerWorker extends Thread {
 private Socket clientsocket;
 private InputStream in;
 private OutputStream out;
 private Server server;
 public ServerWorker(Socket clientsocket, Server server) throws IOException {
	 this.clientsocket = clientsocket;
	 this.server = server;
	 in = clientsocket.getInputStream();
	 out = clientsocket.getOutputStream();
	 System.out.println("New Client Comes");
 }
	@Override
	public void run() {
		// TODO Auto-generated method stub
		// read data and broadcast it
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
		while(true) {
			
				line = br.readLine();
				System.out.println("line readed..." +line);
				
				if(line.equalsIgnoreCase("quit")) {
					break;
				}
				//out.write(line.getBytes());//for single client
				// we have to broadcast
				for(ServerWorker serverworker : server.workers) {
					line = line +"\n";
					serverworker.out.write(line.getBytes());
				}
		}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//break;
			}
		finally {
			try {
			if(br!=null) {
			br.close();
			}
			if(in!=null) {
			in.close();
			}
			if(out!=null) {
			out.close();
			}
			if(clientsocket!=null) {
			clientsocket.close();
			}
		}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
	


