package com.chatapp.others;

import java.util.ResourceBundle;

public  class configreader {
	configreader(){
		
	}
  public static ResourceBundle rb = ResourceBundle.getBundle("config");
  public static  String getvalue(String key) {
	  return rb.getString(key);
	  
  }
}
