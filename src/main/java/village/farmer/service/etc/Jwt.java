package village.farmer.service.etc;

import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.NumericDate;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.jwt.consumer.NumericDateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import village.farmer.entity.User;
import org.jose4j.jwt.consumer.InvalidJwtException;
import village.farmer.model.GenericsResponse;
import village.farmer.statics.ErrorResponseReturnHandle;
import village.farmer.statics.StaticsParameter;

import javax.xml.crypto.Data;
import java.util.Date;

@Service
public class Jwt {

    @Autowired
    Hash hash;
    @Autowired
    CertificateKey certificateKey;
    public String jwtCreate (User user) throws Exception {
        JwtClaims claims = new JwtClaims();
        if (user.getRole().getRoleName().equals("admin")) {
            claims.setAudience("admin");
        } else {
            claims.setAudience("user");
        }
        claims.setClaim("username",user.getCredential().getUsername());
        claims.setExpirationTimeMinutesInTheFuture(StaticsParameter.ACCESS_TOKEN_VALIDITY_MINUTE);
        claims.setGeneratedJwtId();
        claims.setIssuer(StaticsParameter.ISSUER);
        claims.setSubject(hash.sha256Hash(user.getCredential().getUsername()+"_Auth"));

        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        jws.setKey(certificateKey.CertPrivateKey());
        jws.setKeyIdHeaderValue(certificateKey.CertPrivateKey().getAlgorithm());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        return jws.getCompactSerialization();
    }

    public GenericsResponse jwtVerify (String token) throws Exception {
        GenericsResponse response = new GenericsResponse();
        try {
            String format = token.replace("Bearer", "").trim();
            JwtConsumer consumer = new JwtConsumerBuilder()
                    .setSkipAllDefaultValidators()
                    .setRequireExpirationTime()
                    .setExpectedIssuer(StaticsParameter.ISSUER)
                    .setVerificationKey(certificateKey.CertPublicKey())
                    .build();
            try {
                consumer.processToClaims(format);
            } catch (InvalidJwtException e) {
                response.setStatus(401);
                response.setMsg("Invalid token");
                throw new Exception("Invalid token");
            }
            if (consumer.processToClaims(format).getExpirationTime().isBefore(NumericDate.now())) {
                response.setStatus(401);
                response.setMsg("Token expired");
                throw new Exception("Token expired");
            }
            response.setStatus(200);
            response.setMsg("Authorized");
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return response;
        }
    }
}
