package village.farmer.service.etc;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPattern {
    public Boolean mailCheck (String mail) {
        Pattern pattern = Pattern.compile("");
        Matcher matcher = pattern.matcher(mail);
        return matcher.find()?true:false;
    }
    public Boolean passCheck (String password) {
        // not this patch
        return true;
    }
}
