package com.ayush.chatapp.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public interface Encryption {
	
	public static String passwordEncrypt(String plainPassword) throws NoSuchAlgorithmException{
		String encryptedPassword = null;
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(plainPassword.getBytes());
		byte []encrypt = messageDigest.digest();
		System.out.println(encrypt);
		StringBuffer sb = new StringBuffer();
		for(byte b : encrypt) {
			sb.append(b);
		}
		encryptedPassword = sb.toString();
		//encryptedPassword = new String(encrypt);
		System.out.println("Encrypted password "+encryptedPassword);
		return encryptedPassword;
	}

}
