package com.village.farmer.authorization.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

import org.springframework.stereotype.Service;

import com.village.farmer.statics.JwtStaticParameter;

@Service
public class CertificateKey {

	public PrivateKey CertPrivateKey() throws Exception {
		try {
			File file = new File("village.p12");
		    InputStream stream = new FileInputStream(file);
		    KeyStore store = KeyStore.getInstance("PKCS12");
		    store.load(stream, JwtStaticParameter.PASSWORD_CERT.toCharArray());
		    PrivateKey priv = (PrivateKey)store.getKey("ชัยธวัช มหาแก้ว", JwtStaticParameter.PASSWORD_CERT.toCharArray());
		    return priv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;// TODO: handle exception
		}
	}	
	
	public Key CertPublicKey() throws Exception {
		try {
			File file = new File("keyStore.p12");
		    InputStream stream = new FileInputStream(file);
		    KeyStore store = KeyStore.getInstance("PKCS12");
		    store.load(stream, JwtStaticParameter.PASSWORD_CERT.toCharArray());
		    Certificate k = store.getCertificate("ชัยธวัช มหาแก้ว");
		    PublicKey pub = k.getPublicKey();
		    return pub;
		} catch (Exception e) {
			e.printStackTrace();
			return null;// TODO: handle exception
		}
	}
}
