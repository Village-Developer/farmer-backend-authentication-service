package village.farmer.statics;

public class StaticsParameter {

    // jwt
    public static final String SECRET = "05cfbe283381aab8902e93d508ff031c0bcd3f95501c59ee28ac34b21b240fa3"; // secret
    public static final String GRANT_TYPE_PASSWORD = "password";
    public static final String AUTHORIZATION_CODE = "authorization_code";
    public static final String REFRESH_TOKEN = "refresh_token";
    public static final String IMPLICIT = "implicit";
    public static final String ISSUER = "Village Officer";
    public static final String TRUST = "8f6fb3c8079060480d39ae89a45ca9a4311c96dea588a18f9a8d2581cc2412d9";
    public static final int ACCESS_TOKEN_VALIDITY_MINUTE = 24 * 60; // 1 days (day * hours * minutes * second)
    public static final int REFRESH_TOKEN_VALIDITY_MINUTE = 7*24*60; // 7 days (day * hours * minutes * second)
    public static final String JWT_CERT_PASSWORD = "hunta101010";
    public static final String JWT_CERT_ALIAS = "VillageAlias";
    public static final String JWT_CERT_FILE = "jwt.p12";
    public static final String JWT_CERT_INSTANCE_TYPE = "PKCS12";

    public static final String FARMER_PATH = "src\\main\\java\\village\\farmer\\";
    public static final String FARMER_PACKAGE = "village.farmer.";
    public static final String CALL_PACKAGE_CONTROLLER = "controllers";
    public static final String CALL_PACKAGE_MODEL = "model";
    public static final String CALL_PACKAGE_DATABASE = "entity";
}
