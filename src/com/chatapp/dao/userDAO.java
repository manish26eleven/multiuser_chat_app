package com.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.chatapp.dto.userDTO;
import com.chatapp.others.Encryption;

public class userDAO {
	public boolean islogin(userDTO userDTO) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		Connection connection = null;
		PreparedStatement statement = null; 
		ResultSet rs = null;
		try {
			connection = commonDAO.createConnection();
			String sql = "select userid from users where userid=? and password=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1,userDTO.getUserid());
			String pwsd = Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			statement.setString(2,pwsd);
			rs = statement.executeQuery();
			return rs.next();
			//if(rs.next()) {
			//	return true;
			//} else {
				//return false;
				
			//}
		}
		finally {
			if(rs != null) {
				rs.close();
			}
			if(statement!=null) {
				statement.close();
			}
			if(connection!=null) {
				connection.close();
			}
		}
		//return true;
	}
   public int   add(userDTO userDTO) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException {
	   //System.out.println("rec " + userDTO.getUserid() + "" + userDTO.getPassword());
	   Connection connection = null;
	   Statement statement = null;// for queries
	   try {
	   connection = commonDAO.createConnection();//connection created
	   // now do query
	   statement = connection.createStatement();
	   int record = statement.executeUpdate("insert into users(userid,password) values('"+userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"')");
	   return record;
	   }
	   finally {
		   if(statement !=null) {
			   statement.close();
		   }
		   if(connection!=null) {
			   connection.close();
			   
		   }
	   }
   }
	   
}
