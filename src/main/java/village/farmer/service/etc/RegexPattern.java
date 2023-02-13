package village.farmer.service.etc;

import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class RegexPattern {
    public Boolean mailCheck (String mail) {
        Pattern pattern = Pattern.compile("\\w*");
        Matcher matcher = pattern.matcher(mail);
        return matcher.find();
    }
    public Boolean passCheck (String password) {
        return true;
    }
}
