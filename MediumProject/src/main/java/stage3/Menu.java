package stage3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;


public class Menu {
 private static final Scanner scan = new Scanner(System.in);

    private static String printMenu(){
        System.out.println("""
                    === Menu ===
                    1. Find a person
                    2. Print all people
                    0. Exit""");
        return scan.nextLine();

    }
    private static final Map<String , Consumer<String>> actionsMap;
    static {
        actionsMap = Map.of("1",
                (search) -> {
                    String input = scan.nextLine();
                    System.out.println("\nEnter a name or email to search all suitable people.");
                    SearchingEngine.searchPerson(input);},
                "2",
                (search) -> {
                    UsersDataOutput.printAllPeople();});
    }

    public static void selectOption(){
        String menuInput = printMenu();
        while (!menuInput.equals("0")){
            if (actionsMap.get(menuInput) != null){
                actionsMap.get(menuInput).accept(" ");
            }
            else {
                System.out.println("Incorrect option! Try again.");
            }
            menuInput = printMenu();
        }
        System.out.println("\nBye!");
    }

}
