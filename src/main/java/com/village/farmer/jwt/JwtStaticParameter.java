package com.village.farmer.jwt;

public class JwtStaticParameter {
	static final String SECRET = "05cfbe283381aab8902e93d508ff031c0bcd3f95501c59ee28ac34b21b240fa3";
	static final String GRANT_TYPE_PASSWORD = "password";
	static final String AUTHORIZATION_CODE = "authorization_code";
    static final String REFRESH_TOKEN = "refresh_token";
    static final String IMPLICIT = "implicit";
    static final String ISSUER = "SUN";
    static final String TRUST = "8f6fb3c8079060480d39ae89a45ca9a4311c96dea588a18f9a8d2581cc2412d9";
    // day * hours * minutes * second
	static final int ACCESS_TOKEN_VALIDITY_MINUTE = 1*24*60; // 1 days
    static final int REFRESH_TOKEN_VALIDITY_MINUTE = 7*24*60; // 7 days
    //statics certificate
    static final String PRIVATE_KEY_STATICS = 
    		"MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDojlh4SM2KuXTb\r\n"
    + "obr+YQ/hGkbt5gLLwOCvWTlwEsyIK8VVtFbxBMdmOro9ams7lyS+g0CNSnTwn2i1\r\n"
    + "F+baDoofjiFJbjsntSbHT+2QZVelSaweiiGl95s2a/Jtz6X8nAsOVWg/XC7xT9jv\r\n"
    + "vquOVxzl94vi5/FwQcYRyrPvjzcSOeFz+oDbQWecuQn9yPm3RtfKM2BesLg+bU9K\r\n"
    + "UUFYA30aic0RAXDdUsWENbwWwrGKnvhsQbCizNQ3pOmlM5Td1Jvu4GVI4yG8SLeG\r\n"
    + "HXMj8sBS7bLf4om2lJHt3zgUC/K/C5wacfWRoVav/M00d5uTbXS9Dbik7WZ2QPoE\r\n"
    + "da6qWFadAgMBAAECggEAR5ln2KTFj7P4rBRXv7D/lBUkiGM8MiJQqvwECKLpEPW0\r\n"
    + "/GWZLPyFLc7f/z+wAzlOKU+8xKOLbHgP402YGEPIt91pFzQWh2upJE1R/ZaODQgp\r\n"
    + "M3/gyzn4MiG7Ep8PYj5i0wdtoLBPjaFBT9L6+8iLT6xPB83UknTVuC2aB6Qm1vef\r\n"
    + "zhvcM4Gx+Wq22BR6bYiZyCb/Wz17fzapVw7fu0bg+92xmUngVaI6BArusF4sVKOl\r\n"
    + "W9qhY4mSQEN0l/Ee7Z+RSiMCFCEyC3HW3eGMXejTzWBNJokXChdbY1l5vO/ivldf\r\n"
    + "YpkLUQ0ChZJOwgrSA/gXXMW/4GFF7SKS/dOzI+qzWwKBgQDuSZ61+4JVtuGtJ43M\r\n"
    + "ouYXcV5jeI9vYBSeLFdWQ1Y4DlFIAdiG+QF/z179dV36sKOUc4dzrRs7yvqNfueZ\r\n"
    + "BYpYFNuIXYNQVUW1HSpdk+NYyKRGzt5Vg10FA+OZEiLsB3Ape5ahrJS9EyCUfZPh\r\n"
    + "hWg85Y8oD5YHy3mrVLbmCjpaAwKBgQD516j1q5ibudhmUsKezY53ZchDJwPyyDR2\r\n"
    + "WkU4fbOkTtcOPFCI6mTaeBX9B5RYud7YCTIkxoKCQV36L2W1iNkWlJVbZftZwIkX\r\n"
    + "nTkDl3EYQQjoB+DhmLEvT2HfxXqF5jACCg2xAZ+aB8d0VZuhQOoet1L2b6hme9Qt\r\n"
    + "WGPcH9/63wKBgDoeyNBYbTzc44SpfiOoo/iZ1Uzrzgh7ZewCorbOq8v2agrnMFoT\r\n"
    + "iDMVcHTf2LFZvjxqRWKImXjnFF/I0VJ4kHrVc4p6TJoegmcfmwLCHJS+M5t1v7MZ\r\n"
    + "3GlpvmzKiKwLUGc91srOXmUTskGls5kxQfCAiX9a9dwm3CFXA1luqzbjAoGAUTsp\r\n"
    + "GBcemyMllL87v94df/x7zDmXMwyc4g4fi2pzSezIRzydAqcS+2Un4Qjh1qc4KQ10\r\n"
    + "XDienjMalwlqDEfeLVVJ6lmSC3BqIl9f9ib7AmPCvY4yM6ctlLA+pj7Sw05ANamH\r\n"
    + "IhHhDneRBeX/n8I3XJ1GQBG1svx30/Z1IVDLxgkCgYAoENK1PlmxKvWhEnGbawUX\r\n"
    + "bOhUpqkr6uf8hDvSBwwMurYW4506L6drWMVUZ5uHb3TotFel5GKJm5DLNQ4NJLQ5\r\n"
    + "rGD7iHwoHc/ZnJ2+Ww6HJNGiYRVvNUAn2rDOnB0+uhllJ6FHg/2keDxun/dJqnRW\r\n"
    + "qj/aKb7rVD2r+R4H0eY7tg==";
}
