package stage4;

public class UserDataOutput {
    static void printAllPeople(){
        System.out.println("\n=== List of people ===");
        UserDetails.getPeople().forEach(System.out::println);
    }
}
