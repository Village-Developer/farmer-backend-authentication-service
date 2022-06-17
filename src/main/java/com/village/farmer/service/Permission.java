package com.village.farmer.service;

import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.farmer.entity.Credentials;
import com.village.farmer.entity.Users;
import com.village.farmer.repository.CredentialRepository;
import com.village.farmer.repository.UserRepository;
import com.village.farmer.statics.JwtStaticParameter;
import com.village.farmer.statics.StaticsParameter;

@Service
public class Permission {

	@Autowired CredentialRepository credRepo;
	@Autowired UserRepository userRepo;
	
	@Autowired CertificateKey cert;
	
	public Boolean AdminPermission(String token) throws Exception {
		return ValidateJWS(token, StaticsParameter.ROLE_ADMIN);
	}
	
	public Boolean UserPermission(String token) throws Exception {
		return ValidateJWS(token, StaticsParameter.ROLE_USER);
	}
	
	public Boolean ValidateJWS(String token, String role) throws Exception {
		JwtConsumer consume = new JwtConsumerBuilder()
				.setExpectedAudience(role)
				.setExpectedIssuer(JwtStaticParameter.ISSUER)
				.setRequireSubject()
				.setVerificationKey(cert.CertPublicKey()) 
	            .build();
		try {
			JwtClaims jwtClaims = consume.processToClaims(token);
			System.out.println("JWT validation succeeded! " + jwtClaims);
			String subject = jwtClaims.getSubject();
			String data = jwtClaims.getClaimValue("user", String.class);
			if(credRepo.findByUser(data) == null) {
				return false;
			}
			if(subject.equals("Authentication")) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
