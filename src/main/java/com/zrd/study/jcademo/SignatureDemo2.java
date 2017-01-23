package com.zrd.study.jcademo;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class SignatureDemo2 {
	public static void main(String[] args) throws Exception {
		RSAPrivateKeySpec rsaPrivKeySpec = new RSAPrivateKeySpec(new BigInteger("3"), 
				new BigInteger("65537"));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privKey = keyFactory.generatePrivate(rsaPrivKeySpec);
		
		Signature sig = Signature.getInstance("SHA256withRSA");
		sig.initSign(privKey);
		sig.update("你好".getBytes());
		byte[] signResult = sig.sign();
		
		//验签
		RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(new BigInteger("123"), 
				new BigInteger("123"));
		
		PublicKey pubKey = keyFactory.generatePublic(rsaPublicKeySpec);
		
		sig.initVerify(pubKey);
		sig.update("你好".getBytes());
		boolean result = sig.verify(signResult);
		
		System.out.println("验签结果：" + result);
	}
}
