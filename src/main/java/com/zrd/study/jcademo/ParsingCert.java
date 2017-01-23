package com.zrd.study.jcademo;

import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

public class ParsingCert {
	public static void main(String[] args) throws Exception {
		try(InputStream is = ParsingCert.class.getResourceAsStream("/123.cer")){
			CertificateFactory cf = CertificateFactory.getInstance("X.509");
			Certificate cert = cf.generateCertificate(is);
			System.out.println(cert.toString());
		}
	}
}
