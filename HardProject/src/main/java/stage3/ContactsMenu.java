package stage3;
import java.util.Objects;
import java.util.Scanner;

public class ContactsMenu {
    static final Scanner scanner = new Scanner(System.in);
    private static Contacts chooseContactType(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the type (person, organization): ");
        if (Objects.equals(scanner.nextLine(), "person")) return new People();
        else return new Organization();
    }
    public static void addContact() {
        Contacts contact = chooseContactType();
        if (contact instanceof People) AddContact.addPerson((People) contact);
        else AddContact.addOrganization((Organization) contact);
    }

    public static void getNumberOfContactsInList() {
        System.out.println("The Phone Book has " + PhoneBook.getContactsList().size() + " records.\n");
    }

    public static void removeContact() {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        if (PhoneBook.getContactsList().size() == 0) System.out.println("No records to remove!");
        else {
            for (Contacts contact : PhoneBook.getContactsList()) {
                System.out.println(count + ". " + contact.getFullName());
                ++count;
            }
            System.out.print("Select a record: ");
            PhoneBook.getContactsList().remove(scanner.nextInt()-1);
            System.out.println("The record removed!/n");
        }

    }
    public static void editContact() {
        int count = 1;
        if (PhoneBook.getContactsList().size() == 0) System.out.println("No records to edit!");
        else {
            for (Contacts contact : PhoneBook.getContactsList()) {
                System.out.println(count + "." + contact.getFullName());
                ++count;
            }
            System.out.print("Select a record: ");
            Contacts temp =  PhoneBook.getContactsList().get(scanner.nextInt()-1);
            scanner.nextLine();
            if ( temp instanceof People) EditContact.editPerson((People) temp);
            else EditContact.editOrganization((Organization) temp);
        }
    }

    public static void getInfo() {
        int count = 1;
        if(PhoneBook.getContactsList().isEmpty()){
            System.out.println("Phone book is empty.\n");
        }
        else {
            for (Contacts contact : PhoneBook.getContactsList()) {
                System.out.println(count + ". " + contact.getFullName());
                ++count;
            }
            System.out.print("Enter index to show info: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            System.out.println(PhoneBook.getContactsList().get(index-1).toString() + "\n");
        }
    }

}
