package com.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.chatapp.dao.userDAO;
import com.chatapp.dto.userDTO;
import com.chatapp.others.UserInfo;


public class UserScreen extends JFrame{
	private JPasswordField passwordField;
    private JTextField TextArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
			
					UserScreen window = new UserScreen();
					
					
				
			}
	private void dologin() {
		 String userid = TextArea.getText();
			
			char[] password = passwordField.getPassword();
			//System.out.print(userid +"  "+ password.toString());
			userDAO userDAO = new userDAO();
			 userDTO userDTO= new userDTO(userid , password);
			 try {
				if(userDAO.islogin(userDTO)) {
					String message = "WELCOME " + userid;
					UserInfo.USER_NAME = userid;
					JOptionPane.showMessageDialog(this,message);
					setVisible(false);
					dispose();
					DashBoard dashboard = new DashBoard(message);
					dashboard.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this,"invalid userid or password");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	}
	private void register()  {
	     String userid = TextArea.getText();
		
		char[] password = passwordField.getPassword();
		//System.out.print(userid +"  "+ password.toString());
		userDAO userDAO = new userDAO();
		 userDTO userDTO= new userDTO(userid , password);
		 try {
		 int  result = userDAO.add(userDTO);
		 if(result>0) {
			 JOptionPane.showMessageDialog(this,"REGISTERED SUCCESSFULLY");
			 //System.out.println("DONE");
		 } else {
			 //System.out.println("FAILED");
			 JOptionPane.showMessageDialog(this,"NOT REGISTERED , RETRY");
			 
		 }
		 }
		 catch(ClassNotFoundException | SQLException ex) {
			 System.out.println(" databsess issues is there");
			 ex.printStackTrace();
		 } 
		 catch(Exception ex) {
			 System.out.println("some generic issues is there");
			 ex.printStackTrace();
		 }
	}
	 
	
		
	

	/**
	 * Create the application.
	 */
	public UserScreen() {
		getContentPane().setForeground(new Color(0, 0, 0));
		
		setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		
		
		
		setTitle("LOGIN");
		getContentPane().setLayout(null);
		
		
		JLabel login = new JLabel("LOGIN");
		login.setFont(new Font("Constantia", Font.BOLD, 40));
		login.setHorizontalAlignment(SwingConstants.CENTER);
		login.setBounds(325, 102, 250, 60);
		getContentPane().add(login);
		
		JLabel username = new JLabel("USERNAME");
		username.setFont(new Font("Arial", Font.BOLD, 19));
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(253, 198, 128, 39);
		getContentPane().add(username);
		
		JLabel pwd = new JLabel("PASSWORD");
		pwd.setHorizontalAlignment(SwingConstants.CENTER);
		pwd.setFont(new Font("Arial", Font.BOLD, 19));
		pwd.setBounds(253, 258, 128, 39);
		getContentPane().add(pwd);
		
		 TextArea = new JTextField();
		//usertxt.setEnabled(false);
		//usertxt.setEditable(false);
		TextArea.setBorder(new LineBorder(new Color(0, 0, 0)));
		//usertxt.setLineWrap(true);
		TextArea.setBounds(425, 205, 198, 32);
		getContentPane().add(TextArea);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(171, 173, 179), 2, true));
		passwordField.setBounds(425, 258, 203, 32);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dologin();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBounds(300, 363, 113, 39);
		getContentPane().add(btnNewButton);
		
		JButton btnRegister = new JButton("REGISTER");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		btnRegister.setFont(new Font("Arial", Font.BOLD, 20));
		btnRegister.setBounds(476, 363, 147, 39);
		getContentPane().add(btnRegister);
		
		//setTitle.
		setSize( 900, 607);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
	}
	
}
