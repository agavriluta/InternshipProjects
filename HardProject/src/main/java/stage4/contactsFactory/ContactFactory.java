package stage4.contactsFactory;

import stage4.Menu;

import java.time.LocalDateTime;

public abstract class ContactFactory {
    public Contact getContact(ContactType type) {
        Contact contact = createContact(type);
        System.out.println("Enter phone number");
        contact.setNumber(contact.filterPhoneNumber(Menu.getUserInput()));
        contact.setCreationDateTime(LocalDateTime.now().withNano(0));
        contact.setLastEditDateTime(LocalDateTime.now().withNano(0));
        return contact;
    }

    abstract Contact createContact(ContactType type);
}
