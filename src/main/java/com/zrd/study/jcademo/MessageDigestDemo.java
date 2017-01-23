package com.zrd.study.jcademo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MessageDigestDemo {
	public static void main(String[] args) throws NoSuchAlgorithmException, CloneNotSupportedException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		digest.update("nih".getBytes());
		digest.update("你好".getBytes());
		byte[] result = digest.digest();
		System.out.println(Base64.getEncoder().encodeToString(result));
		
		digest.update("nih".getBytes());
		digest.update("你好".getBytes());
		result = digest.digest();
		System.out.println(Base64.getEncoder().encodeToString(result));
		
		digest.update("nih".getBytes());
		digest.update("你好".getBytes());
		result = ((MessageDigest) digest.clone()).digest();
		System.out.println(Base64.getEncoder().encodeToString(result));
		digest.update("nih".getBytes());
		digest.update("你好".getBytes());
		result = digest.digest();
		System.out.println(Base64.getEncoder().encodeToString(result));
	}
}
