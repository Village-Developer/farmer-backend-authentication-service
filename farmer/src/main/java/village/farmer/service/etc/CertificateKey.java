package village.farmer.service.etc;

import org.springframework.stereotype.Service;
import village.farmer.statics.StaticsParameter;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.Certificate;

@Service
public class CertificateKey {
    public PrivateKey CertPrivateKey() throws Exception {
        try {
            File file = new File(StaticsParameter.JWT_CERT_FILE);
            InputStream stream = new FileInputStream(file);
            KeyStore store = KeyStore.getInstance(StaticsParameter.JWT_CERT_INSTANCE_TYPE);
            store.load(stream, StaticsParameter.JWT_CERT_PASSWORD.toCharArray());
            PrivateKey priv = (PrivateKey)store.getKey(StaticsParameter.JWT_CERT_ALIAS, StaticsParameter.JWT_CERT_PASSWORD.toCharArray());
            return priv;
        } catch (Exception e) {
            System.out.println("err");
            e.printStackTrace();
            return null;// TODO: handle exception
        }
    }

    public Key CertPublicKey() throws Exception {
        try {
            File file = new File(StaticsParameter.JWT_CERT_FILE);
            InputStream stream = new FileInputStream(file);
            KeyStore store = KeyStore.getInstance(StaticsParameter.JWT_CERT_INSTANCE_TYPE);
            store.load(stream, StaticsParameter.JWT_CERT_PASSWORD.toCharArray());
            Certificate k = store.getCertificate(StaticsParameter.JWT_CERT_ALIAS);
            PublicKey pub = k.getPublicKey();
            return pub;
        } catch (Exception e) {
            e.printStackTrace();
            return null;// TODO: handle exception
        }
    }
}
