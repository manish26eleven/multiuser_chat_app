package com.chatapp.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.chatapp.network.Client;
//import com.chatapp.utils.UserInfo;
import com.chatapp.others.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.rmi.UnknownHostException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea ;
	private Client client ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
					try {
						ClientChatScreen frame = new ClientChatScreen();
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	}
	private void sendIt() {
		String message = textField.getText();
		try {
			client.SendMessages( UserInfo.USER_NAME+" - "+message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		setFont(new Font("Dialog", Font.BOLD, 10));
		setTitle(" Chit Chat");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 410);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 6, 642, 305);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		//textField.setBackground(new Color(255, 128, 192));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(10, 322, 487, 51);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton sendit = new JButton("SEND");
		//sendit.setBackground(new Color(128, 128, 64));
		sendit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		sendit.setFont(new Font("Dialog", Font.BOLD, 20));
		sendit.setBounds(513, 317, 139, 56);
		contentPane.add(sendit);
		textArea= new JTextArea();
		contentPane.add(textArea);
		textArea.setLineWrap(true);
		client= new Client(textArea);
		
		
		textArea.setFont(new Font("Monospaced", Font.ITALIC, 16));
		//		contentPane.add(textArea);
		//		textArea.setLineWrap(true);
				textArea.setBounds(15, 7, 624, 264);
		setVisible(true);
	}
	
}
