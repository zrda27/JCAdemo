package com.zrd.study.jcademo;

import java.security.cert.CertPath;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public class CertPathDemo {
	public static void main(String[] args) throws CertificateException {
		 // create the certificate factory
        CertificateFactory fact = CertificateFactory.getInstance("X509");
        CertPath certPath = fact.generateCertPath(CertPathDemo.class.getResourceAsStream("/NETCAClassA证书链.p7b"), "PKCS7");
        System.out.println(certPath.getType());
	}
}
