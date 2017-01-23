package com.zrd.study.jcademo;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class SignatureDemo {
	public static void main(String[] args) throws Exception {
		//签名
		Signature signature = Signature.getInstance("SHA256withRSA");
		
		PrivateKey privKey = KeyPairDemo.getKeyPair().getPrivate();
		
		signature.initSign(privKey);
		
		signature.update("123".getBytes());
		byte[] signResult = signature.sign();
		
		//验签
		PublicKey pubKey = KeyPairDemo.getKeyPair().getPublic();
		
		signature.initVerify(pubKey);
		
		signature.update("123".getBytes());
		
		boolean result = signature.verify(signResult);
		
		System.out.println("验签结果：" + result);
	}
}
