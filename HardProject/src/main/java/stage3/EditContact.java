package stage3;

import java.time.LocalDateTime;

import static stage3.ContactsMenu.scanner;

public class EditContact {
    static void editPerson(People contact){
        System.out.print("Select a field (name, surname, birth, gender, number): ");
        switch (scanner.nextLine()) {
            case "name" -> {
                System.out.print("Enter name: ");
                contact.setName(scanner.nextLine());
            }
            case "surname" -> {
                System.out.print("Enter surname: ");
                contact.setSurname(scanner.nextLine());
            }
            case "number" -> {
                System.out.print("Enter number: ");
                contact.setNumber(scanner.nextLine());
            }
            case "birth" -> {
                System.out.print("Enter birth date: ");
                contact.setBirthDate(scanner.nextLine());
            }
            case "gender" ->{
                System.out.print("Enter gender: ");
                contact.setGender(scanner.nextLine());
            }
        }
        System.out.println("The record updated!\n");
        contact.setEdition(LocalDateTime.now().withSecond(0).withNano(0));
    }
    static void editOrganization(Organization contact){
        System.out.print("Select a field (address, number): ");
        switch (scanner.nextLine()) {
            case "address" -> {
                System.out.print("Enter name: ");
                contact.setAddress(scanner.nextLine());
            }
            case "number" -> {
                System.out.print("Enter number: ");
                contact.setNumber(scanner.nextLine());
            }
        }
        System.out.println("The record updated!\n");
        contact.setEdition(LocalDateTime.now().withSecond(0).withNano(0));
    }
}

