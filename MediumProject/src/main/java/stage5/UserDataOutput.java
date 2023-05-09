package stage5;

import stage4.UserDetails;

public class UserDataOutput {
    static void printAllPeople(){
        System.out.println("\n=== List of people ===");
        UserDetails.getPeople().forEach(System.out::println);
    }
}
