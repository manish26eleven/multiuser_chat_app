package com.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import com.chatapp.others.configreader;
import java.util.Scanner;

import javax.swing.JTextArea;

public class Client {
	
 Socket socket;
 OutputStream out;
 InputStream in;
 ClientWorker worker;
 JTextArea textarea;
 public Client(JTextArea textarea) throws UnknownHostException, IOException {
	 int PORT = Integer.parseInt(configreader.getvalue("PORTNO"));
 socket = new Socket(configreader.getvalue("SERVER_IP"),PORT);
 out = socket.getOutputStream();
 in = socket.getInputStream();
 this.textarea = textarea;
  ReadMessages();
// System.out.println("Client comes...");
// System.out.println("ready to send messages ,, write messages to be sent");
 //Scanner sc = new Scanner(System.in);
 //String msg = sc.nextLine();
 //OutputStream out = socket.getOutputStream();
 //out.write(msg.getBytes());
 //System.out.println("message sent to server  ");
 //out.close();
 //sc.close();
 //socket.close();
    
 }
 public void SendMessages(String Message) throws IOException {
	 Message = Message +"\n";
	 out.write(Message.getBytes());
 }
 public void ReadMessages() {
	 worker = new ClientWorker(in , textarea);
	 worker.start();
 }
	//public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		//Client Client = new Client();
		

	//}

}
