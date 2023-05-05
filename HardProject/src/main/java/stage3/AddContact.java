package stage3;

import java.time.LocalDateTime;
import static stage3.ContactsMenu.scanner;

public class AddContact {
    static void addOrganization(Organization contact) {
        System.out.print("Enter the organization name: ");
        contact.setOrganizationName(scanner.nextLine());
        System.out.print("Enter the address: ");
        contact.setAddress(scanner.nextLine());
        System.out.print("Enter the number: ");
        contact.setNumber(scanner.nextLine());
        System.out.println("The record added.\n");
        contact.setEdition(LocalDateTime.now().withSecond(0).withNano(0));
        PhoneBook.getContactsList().add(contact);
    }

    static void addPerson(People contact){
        System.out.print("Enter the name: ");
        contact.setName(scanner.nextLine());
        System.out.print("Enter the surname: ");
        contact.setSurname(scanner.nextLine());
        System.out.print("Enter the birth date: ");
        contact.setBirthDate(scanner.nextLine());
        System.out.print("Enter the gender (M, F): ");
        contact.setGender(scanner.nextLine());
        System.out.print("Enter the number: ");
        contact.setNumber(scanner.nextLine());
        System.out.println("The record added.\n");
        contact.setEdition(LocalDateTime.now().withSecond(0).withNano(0));
        PhoneBook.getContactsList().add(contact);

    }
}
