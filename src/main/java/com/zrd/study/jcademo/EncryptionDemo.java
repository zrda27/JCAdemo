package com.zrd.study.jcademo;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class EncryptionDemo {
	public static void main(String[] args) throws Exception {
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		SecretKey aesKey = keygen.generateKey();
		
		Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		aesCipher.init(Cipher.ENCRYPT_MODE, aesKey);
		
		byte[] encResult = aesCipher.doFinal("你好".getBytes());
		
		aesCipher.init(Cipher.DECRYPT_MODE, aesKey);
		
		String plainText = new String(aesCipher.doFinal(encResult));
		System.out.println(plainText);
	}
}
