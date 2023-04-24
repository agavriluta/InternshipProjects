package stage4;
import java.util.List;
public class UserDetails {
    private static List<Person> people;
    public static List<Person> getPeople() {
        return people;
    }

    public static void setPeople(List<Person> people) {
        UserDetails.people = people;
    }
}
