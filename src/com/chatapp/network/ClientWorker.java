package com.chatapp.network;

import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientWorker extends Thread{
	private  InputStream in;
	private JTextArea textarea;
	public ClientWorker(InputStream in,JTextArea textarea) {
		this.in = in;
		this.textarea = textarea;
		
	}
	@Override
public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
	while(true) {
		line = br.readLine();
		line = line +"\n";
		System.out.println("Line Read " + line );
		textarea.setText(textarea.getText() + line +"\n" );
	}
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	
}
}
