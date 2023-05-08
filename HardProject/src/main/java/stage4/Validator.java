package stage4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern pattern = Pattern.compile("[+]?(\\w+[\\s-]?)*(\\(?\\w{2,}\\)?([\\s-]\\w+)*)?|[+]?\\(?\\w+\\)?[\\s-]\\w{2,}([\\s-]\\w+)*");
    public static boolean checkNumber(String number) {
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
