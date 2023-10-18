package com.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; 
import static com.chatapp.others.configreader.getvalue;

public interface commonDAO  {
  public static Connection createConnection() throws ClassNotFoundException, SQLException {
	 
	  // load the driver
	  Class.forName(getvalue("DRIVER"));
	  // now making the connection
	 final String CONNECTION_STRING = getvalue("CONNECTION_URL");
	 final String USER_ID = getvalue("USERID");
	 final String  PASSWORD = getvalue("PASSWORD");
	  Connection con  = DriverManager.getConnection(CONNECTION_STRING,USER_ID,PASSWORD);
	  if(con!=null) {
		  System.out.println("connection created....");
		  //con.close();
	  } 
	  return con;
  }
 
}
