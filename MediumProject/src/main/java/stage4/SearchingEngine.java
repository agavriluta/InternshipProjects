package stage4;
import java.util.List;
public class SearchingEngine {
    private static final List<Person> generalListOfUsers = List.copyOf(UserDetails.getPeople());

    public static void searchPerson(String searchingWord){
        List<Person> foundUsers = searchUsers( searchingWord);
        printSearchResult(foundUsers);
    }

    private static List<Person> searchUsers( String searchingWord) {
        return generalListOfUsers.stream().findAny()
                .stream()
                .filter(p -> p.toString().toLowerCase().contains(searchingWord))
                .toList();

    }

    private static void printSearchResult(List<Person> res) {
        if (res.isEmpty()) System.out.println("No matching people found.");
        else {
            System.out.println();
            System.out.println("Found people:");
            res.forEach(System.out::println);
        }
    }
}
