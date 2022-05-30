package com.village.farmer.jwt;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;

import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.keys.HmacKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.farmer.model.request.LoginRequest;
import com.village.farmer.repository.UserRepository;

@Service
public class JwtAuth {

	@Autowired UserRepository userRepo;
	
	public String ClaimAuth(LoginRequest login) throws Exception {
		JwtClaims claim = new JwtClaims();
		//claim.setAudience(userRepo.findByUser(login.getUsername()).getRoleID().iterator().next().getRole());
		claim.setAudience("admin");
		claim.setExpirationTimeMinutesInTheFuture(JwtStaticParameter.ACCESS_TOKEN_VALIDITY_MINUTE);
		claim.setGeneratedJwtId();
		claim.setIssuer(JwtStaticParameter.ISSUER);
		claim.setSubject("Authentication");
		claim.setClaim("Credential", login);
		
		JsonWebEncryption jwe = new JsonWebEncryption();
		jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.A128GCMKW);
		jwe.setContentEncryptionKey(privKeyGenerate().getEncoded());
		jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_128_GCM);
//		jwe.setIv(SecureRandom.getInstance("SHA1PRNG").generateSeed(64));
		jwe.setDoKeyValidation(false);
		jwe.setKey(privKeyGenerate());
		jwe.setPayload(claim.toJson());
		
		return jwe.getCompactSerialization();
	}
	
	public PrivateKey privKeyGenerate() throws Exception {
		String pass = "hunta101010";
		try {
			File file = new File("village.p12");
		    InputStream stream = new FileInputStream(file);
		    KeyStore store = KeyStore.getInstance("PKCS12");
		    store.load(stream, pass.toCharArray());
		    PrivateKey priv = (PrivateKey)store.getKey("VillageAlias", pass.toCharArray());
		    if (priv==null) {
				System.err.println("cert data null");
			} else {
				System.out.println(priv.toString());
			}
		    return priv;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Password Wrong");
			return null;// TODO: handle exception
		}
	}
	
	public Boolean ValidateJWS(String token) throws Exception {
		JwtConsumer consume = new JwtConsumerBuilder()
				.setExpectedAudience("admin")
				.setExpectedIssuer(JwtStaticParameter.ISSUER)
				.setRequireSubject()
				.setDecryptionKey(privKeyGenerate())
				.setDisableRequireSignature()
                .build();
		try {
			JwtClaims jwtClaims = consume.processToClaims(token);
			String subject = jwtClaims.getSubject();
			if(subject.equals("Authentication")) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			return false;
		}
		
	}
}
