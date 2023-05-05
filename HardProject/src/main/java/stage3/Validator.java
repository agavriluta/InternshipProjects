package stage3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final Pattern pattern = Pattern.compile("[+]?(\\w+[\\s-]?)*(\\(?\\w{2,}\\)?([\\s-]\\w+)*)?|[+]?\\(?\\w+\\)?[\\s-]\\w{2,}([\\s-]\\w+)*");
    public static boolean checkNumber(String number) {
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static boolean checkBirthDate(String birthDate){
        try {
            LocalDate.parse(birthDate);
        } catch (DateTimeException e) {
            return false;
        }
        return true;
    }

    public static boolean checkGender(String gender) {
        return gender.equals("M")|| gender.equals("F");
    }
}
