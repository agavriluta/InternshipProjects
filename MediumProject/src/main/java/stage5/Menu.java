package stage5;
import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class Menu {
    private static final Scanner scan = new Scanner(System.in);
    private static File file ;
    public static void setFile(String arg){
        file = new File(arg);
    }

    public static File getFile() {
        return file;
    }

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
                    System.out.println("\nEnter a name or email to search all suitable people.");
                    String input = scan.nextLine();
                    InvertedIndexSearch.findPerson(input , file );},
                "2",
                (search) -> {
                    UserDataOutput.printAllPeople();});
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

