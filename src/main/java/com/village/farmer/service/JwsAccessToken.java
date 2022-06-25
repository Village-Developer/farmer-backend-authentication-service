package com.village.farmer.service;

import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.village.farmer.entity.Credentials;
import com.village.farmer.entity.Users;
import com.village.farmer.model.request.LoginRequest;
import com.village.farmer.repository.CredentialRepository;
import com.village.farmer.repository.UserRepository;
import com.village.farmer.statics.JwtStaticParameter;
import com.village.farmer.statics.StatusStatic;

@Service
public class JwsAccessToken {

	@Autowired UserRepository userRepo;
    @Autowired CredentialRepository credRepo;
    
    @Autowired CertificateKey cert;
	
	public String ClaimAuth(LoginRequest login) throws Exception {
		Credentials cred = credRepo.findByUser(login.getUsername());
		if(cred == null) {
			throw new Exception(StatusStatic.AUTH_01);
		}
		if(!(login.getPassword().equals(cred.getPass()))) {
			throw new Exception(StatusStatic.AUTH_02);
		}
		try {
			Users user = userRepo.findByCred(cred);
			JwtClaims claim = new JwtClaims();
			claim.setAudience(user.getRole_id().getRole());
			claim.setExpirationTimeMinutesInTheFuture(JwtStaticParameter.ACCESS_TOKEN_VALIDITY_MINUTE);
			claim.setGeneratedJwtId();
			claim.setIssuer(JwtStaticParameter.ISSUER);
			claim.setSubject("Authentication");
			claim.setClaim("user", login.getUsername());
			
			JsonWebSignature jws = new JsonWebSignature();
			jws.setPayload(claim.toJson());
			jws.setKey(cert.CertPrivateKey());
			jws.setKeyIdHeaderValue(cert.CertPrivateKey().getAlgorithm());
			jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
			String jwt = jws.getCompactSerialization();
			return jwt;
		} catch (Exception e) {
			throw new Exception(StatusStatic.AUTH_03);
		}
	}
}
