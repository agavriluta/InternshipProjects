package stage3;
import java.util.*;

public class SearchingEngine {

    private static final List<String> generalListOfUsers = List.copyOf(UserDetails.addUsersToGeneralList());

    public static void searchPerson(String searchingWord){
        Set<String> foundUsers = new HashSet<>();
        searchUsers(foundUsers , searchingWord);
        printSearchResult(foundUsers);
    }

    private static void searchUsers(Set<String> foundUsers , String searchingWord) {
        foundUsers.clear();
        for (String row: generalListOfUsers) {
            if (row.compareToIgnoreCase(searchingWord) != -1) {
                foundUsers.add(row);
            }
        }
    }

    private static void printSearchResult(Set<String> res) {
        if (res.isEmpty()) System.out.println("No matching people found.");
        else {
            System.out.println();
            System.out.println("Found people:");
            res.forEach(System.out::println);
            System.out.println();
        }
    }


}


