package stage3;

import java.util.*;
import java.util.function.Consumer;

public class PhoneBook {
    private static final List<Contacts> contactsList;
    static {
        contactsList = new ArrayList<>();
    }
    private static final Map<String, Consumer<String>> actionsMap;

    static {
        Consumer<String> add = (search) -> {
            ContactsMenu.addContact();
        };
        Consumer<String> remove = (search) -> {
            ContactsMenu.removeContact();
        };
        Consumer<String> edit = (search) -> {
            ContactsMenu.editContact();
        };
        Consumer<String> count = (search) -> {
            ContactsMenu.getNumberOfContactsInList();
        };
        Consumer<String> info = (search) -> {
            ContactsMenu.getInfo();
        };
        actionsMap = new HashMap<>();
        actionsMap.put("add", add);
        actionsMap.put("remove", remove);
        actionsMap.put("edit", edit);
        actionsMap.put("info", info);
        actionsMap.put("count", count);
    }


    public static void chooseMenuOption(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter action (add, remove, edit, count, info, exit): ");
        String option = sc.nextLine();
        while(!Objects.equals(option, "exit")){
            actionsMap.get(option).accept(" ");
            System.out.print("Enter action (add, remove, edit, count, info, exit): ");
            option = sc.nextLine();

        }
    }

    public static List<Contacts> getContactsList() {
        return contactsList;
    }


}