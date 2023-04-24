package stage3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserDetails {
    private static List<String> people;
    private static final Scanner scan = new Scanner(System.in);
    public static void setPeople() {
        UserDetails.people = addUsersToGeneralList();
    }

    public static List<String> getPeople() {
        return people;
    }

   static List<String> addUsersToGeneralList(){
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
}
