package stage2;
import java.util.*;

public class Searching {

    private static final Scanner scan = new Scanner(System.in);
    private static List<String> addUsersToGeneralList(){
        System.out.println("Enter the number of people:");
        int size = scan.nextInt();
        scan.nextLine();
        System.out.println("Enter all people:");
        List<String> userDetailsList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            userDetailsList.add(scan.nextLine());
        }
        return userDetailsList;
    }
    public static void searchEngine(){
        System.out.println("Enter the number of search queries:");
        int numberOfSearchQueries = scan.nextInt();
        System.out.println();
        Set<String> foundUsers = new HashSet<>();
        scan.nextLine();
        for (int i = 0; i < numberOfSearchQueries; i++) {
            searchUsers(foundUsers);
            printResult(foundUsers);
        }
    }

    private static void searchUsers(Set<String> foundUsers) {
        System.out.println("Enter data to search people:");
        String searchWord = scan.nextLine();
        foundUsers.clear();
        for (String row: addUsersToGeneralList()) {
            if (row.contains(searchWord)) {
                foundUsers.add(row);
            }
        }
    }

    private static void printResult(Set<String> foundPeopleList) {
        if (foundPeopleList.isEmpty()) System.out.println("No matching people found.");
        else {
            System.out.println();
            System.out.println("Found people:");
            foundPeopleList.forEach(System.out::println);
            System.out.println();
        }
    }

}

