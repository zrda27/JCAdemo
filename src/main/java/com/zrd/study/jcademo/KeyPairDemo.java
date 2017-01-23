package com.zrd.study.jcademo;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

public class KeyPairDemo {
	public static void main(String[] args) throws Exception {
		KeyPair pair = getKeyPair();
		
		System.out.println(pair.getPrivate());
	}
	
	public static KeyPair getKeyPair() throws Exception{
		//密钥对生成器
		KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
		//初始化
		SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
		random.setSeed("123".getBytes());
		keyGen.initialize(1024, random);
		//产生密钥对
		return keyGen.generateKeyPair();
	}
}
