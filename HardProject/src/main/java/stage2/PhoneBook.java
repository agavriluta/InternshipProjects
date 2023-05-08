package stage2;

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
        Consumer<String> list = (search) -> {
            ContactsMenu.printList();
        };
        Consumer<String> count = (search) -> {
            ContactsMenu.getNumberOfContactsInList();
        };
        actionsMap = new HashMap<>();
        actionsMap.put("add", add);
        actionsMap.put("remove", remove);
        actionsMap.put("edit", edit);
        actionsMap.put("list", list);
        actionsMap.put("count", count);
    }


    public static void chooseMenuOption(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter action (add, remove, edit, count, list, exit): ");
        String option = sc.nextLine();
        while(!Objects.equals(option, "exit")){
            actionsMap.get(option).accept(" ");
            System.out.print("Enter action (add, remove, edit, count, list, exit): ");
            option = sc.nextLine();

        }
    }

    public static List<Contacts> getContactsList() {
        return contactsList;
    }
}
