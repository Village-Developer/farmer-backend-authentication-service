package village.farmer.service.etc;

import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import village.farmer.entity.User;
import village.farmer.statics.StaticsEnum;
import village.farmer.statics.StaticsParameter;

@Service
public class Jwt {

    @Autowired
    Hash hash;
    @Autowired
    CertificateKey certificateKey;
    public String jwtCreate (User user) throws Exception {
        JwtClaims claims = new JwtClaims();
        claims.setAudience(user.getRole().getRoleName());
        claims.setExpirationTimeMinutesInTheFuture(StaticsParameter.ACCESS_TOKEN_VALIDITY_MINUTE);
        claims.setGeneratedJwtId();
        claims.setIssuer(StaticsParameter.ISSUER);
        claims.setSubject(hash.sha256Hash(user.getCredential().getUsername()+"_Auth"));
        claims.setClaim("username",user.getCredential().getUsername());

        JsonWebSignature jws = new JsonWebSignature();
        jws.setPayload(claims.toJson());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        jws.setKey(certificateKey.CertPrivateKey());
        jws.setKeyIdHeaderValue(certificateKey.CertPrivateKey().getAlgorithm());
        jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);
        String jwt = jws.getCompactSerialization();
        return jwt;
    }

    public Boolean jwtVerify (String token, String role, String user) throws Exception {
        try {
            JwtConsumer consumer = new JwtConsumerBuilder()
                    .setExpectedAudience(role)
                    .setExpectedIssuer(StaticsParameter.ISSUER)
                    .setRequireSubject()
                    .setExpectedSubject(user+"_Auth")
                    .setVerificationKey(certificateKey.CertPublicKey())
                    .build();
            JwtClaims claims = consumer.processToClaims(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean jwtVerify (String token, String role) throws Exception {
        try {
            JwtConsumer consumer = new JwtConsumerBuilder()
                    .setExpectedAudience(role)
                    .setExpectedIssuer(StaticsParameter.ISSUER)
                    .setVerificationKey(certificateKey.CertPublicKey())
                    .build();
            JwtClaims claims = consumer.processToClaims(token);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getUserFromToken (String token) throws Exception {
        try {
            JwtConsumer consumer = new JwtConsumerBuilder()
                    .setExpectedIssuer(StaticsParameter.ISSUER)
                    .setVerificationKey(certificateKey.CertPublicKey())
                    .build();
            JwtClaims claims = consumer.processToClaims(token);
            return claims.getStringClaimValue("username");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Boolean RoleAdminAuthorized (String token) throws Exception {
        return jwtVerify(token, StaticsEnum.Role_Admin.displayName()); // กำลังคิด
    }
    public Boolean RoleVillageAuthorized (String token) throws Exception {
        return jwtVerify(token, StaticsEnum.Role_Villager.displayName()); // กำลังคิด
    }
    public Boolean RoleUserAuthorized (String token) throws Exception {
        return jwtVerify(token, StaticsEnum.Role_User.displayName()); // กำลังคิด
    }
}
