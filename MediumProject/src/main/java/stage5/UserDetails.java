package stage5;

import java.util.List;

public class UserDetails {
    private static List<stage5.Person> people;
    public static List<stage5.Person> getPeople() {
        return people;
    }

    public static void setPeople(List<Person> people) {
        UserDetails.people = people;
    }
}
