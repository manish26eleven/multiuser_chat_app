package com.chatapp.others;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
  public  static String passwordEncrypt(String plain_password) throws NoSuchAlgorithmException {
	  String encrypted_password = null;
	  MessageDigest messageDigest = MessageDigest.getInstance("MD5");
	  messageDigest.update(plain_password.getBytes());
	  byte [] encrypt = messageDigest.digest();
	  encrypted_password = new String(encrypt);
	  System.out.println("Encrypted password -> " + encrypted_password);
	  return encrypted_password;
    }
 
}
