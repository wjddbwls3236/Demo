package com.example.demo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PwdChange {
	
	public static String getPassWord(String password,String salt) throws NoSuchAlgorithmException {
		
		//비번 암호화ㅑ
				String raw = password; //사용자 비번
				
				SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
				byte[] bytes = new byte[16];
				random.nextBytes(bytes);
				

				MessageDigest md = MessageDigest.getInstance("SHA-256");
				if(salt != null) {
					md.update(salt.getBytes());
				}
				md.update(raw.getBytes());
				String hex = String.format("%064x", new BigInteger(1, md.digest()));
				
				return hex;
	}
}
