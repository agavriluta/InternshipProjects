package stage2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckNumber {
    private static final Pattern pattern = Pattern.compile("[+]?(\\w+[\\s-]?)*(\\(?\\w{2,}\\)?([\\s-]\\w+)*)?|[+]?\\(?\\w+\\)?[\\s-]\\w{2,}([\\s-]\\w+)*");
    /*Pattern.compile("[+]?[a-zA-Z0-9]+([\\s-][a-zA-Z0-9]{2,})+ |" +
    " /[+]?[\\w]+[\\s-]\\(\\w{2,}\\)([\\s-]\\w{2,})+|" +
    " [+]?[a-zA-Z0-9]+[\\s-]\\([a-zA-Z0-9]{2,}\\)([\\s-][a-zA-Z0-9]{2,})*");*/
    public static boolean isValid(Contacts object , String number) {
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
