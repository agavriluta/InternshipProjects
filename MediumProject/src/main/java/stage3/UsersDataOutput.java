package stage3;

public class UsersDataOutput {
    static void printAllPeople(){
        System.out.println("\n=== List of people ===");
        UserDetails.getPeople().forEach(System.out::println);
    }
}
