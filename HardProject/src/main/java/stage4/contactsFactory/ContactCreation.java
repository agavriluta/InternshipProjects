package stage4.contactsFactory;

import stage4.Menu;

public class ContactCreation extends ContactFactory {
    @Override
    final Contact createContact(ContactType type) {
        Contact contact = null;
        if (ContactType.PERSON == type) {
            PersonContact person = new PersonContact();
            System.out.println("Enter name");
            person.setName(Menu.getUserInput());
            System.out.println("Enter surname");
            person.setSurname(Menu.getUserInput());
            System.out.println("Enter birth date(yyyy-MM-dd)");
            person.setBirthDate(person.tryCastStrToDate(Menu.getUserInput()));
            System.out.println("Enter gender(M|F)");
            person.setGender(person.tryCastStrToGender(Menu.getUserInput()));
            contact = person;
        } else if (ContactType.ORGANIZATION == type) {
            OrganizationContact organization = new OrganizationContact();
            System.out.println("Enter name");
            organization.setName(Menu.getUserInput());
            System.out.println("Enter address");
            organization.setAddress(Menu.getUserInput());
            contact = organization;
        }
        return contact;
    }
}

