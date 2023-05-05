package stage2;

import java.util.Scanner;

public class ContactsMenu {
    public static void addContact() {
        Scanner scanner = new Scanner(System.in);
        Builder builder = new Contacts.ContactsBuilder();
        System.out.print("Enter the name: ");
        builder.setName(scanner.nextLine());
        System.out.print("Enter the surname: ");
        builder.setSurname(scanner.nextLine());
        System.out.print("Enter the number: ");
        builder.setNumber(scanner.nextLine());
        PhoneBook.getContactsList().add(builder.build());
        System.out.println("The record added.");
    }

    public static void getNumberOfContactsInList() {
        System.out.println("The Phone Book has " + PhoneBook.getContactsList().size() + " records.");
    }

    public static void removeContact() {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        if (PhoneBook.getContactsList().size() == 0) System.out.println("No records to remove!");
        else {
            for (Contacts contact : PhoneBook.getContactsList()) {
                System.out.println(count + "." + contact.toString());
                ++count;
            }
            System.out.print("Select a record: ");
            PhoneBook.getContactsList().remove(scanner.nextInt());
            System.out.println("The record removed!");
        }

    }

    public static void editContact() {
        Scanner scanner = new Scanner(System.in);
        int count = 1;
        if (PhoneBook.getContactsList().size() == 0) System.out.println("No records to edit!");
        else {
            for (Contacts contact : PhoneBook.getContactsList()) {
                System.out.println(count + "." + contact.toString());
                ++count;
            }
            System.out.print("Select a record: ");
            int record = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Select a field (name, surname, number): ");
            switch (scanner.nextLine()) {
                case "name" -> {
                    System.out.print("Enter name: ");
                    PhoneBook.getContactsList().get(record).setName(scanner.nextLine());
                }
                case "surname" -> {
                    System.out.print("Enter surname: ");
                    PhoneBook.getContactsList().get(record).setSurname(scanner.nextLine());
                }
                case "number" -> {
                    System.out.print("Enter number: ");
                    PhoneBook.getContactsList().get(record).setNumber(scanner.nextLine());
                }
            }
            System.out.println("The record updated!");
        }

    }

    public static void printList() {
        int count = 1;
        for (Contacts contact : PhoneBook.getContactsList()) {
            System.out.println(count + "." + contact.toString());
            ++count;
        }
    }

}
