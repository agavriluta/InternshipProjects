package stage4;

import stage4.contactsFactory.Contact;
import stage4.contactsFactory.ContactCreation;
import stage4.contactsFactory.ContactType;

import java.io.IOException;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class PhoneBook {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static String filename;

    public static void setContacts(ArrayList<Contact> contacts) {
        PhoneBook.contacts = new ArrayList<>(contacts);
    }

    public static void setFilename(String filename) {
        PhoneBook.filename = filename;
    }

    public static int getContactSize() {
        return contacts.size();
    }

    public static Contact getContactById(int contactId) {
        return contacts.get(contactId);
    }

    public static void addPerson() {
        contacts.add(new ContactCreation().getContact(ContactType.PERSON));
        System.out.println("Contact added.");
    }

    public static void addOrganization() {
        contacts.add(new ContactCreation().getContact(ContactType.ORGANIZATION));
        System.out.println("Contact added.");
    }

    public static void listContacts() {
        final int size = contacts.size();
        for (int i = 0; i < size; i++) {
            contacts.get(i).showContactsListItem(i + 1);
        }
    }

    public static void showContact(int inputIndex) {
        System.out.println(contacts.get(inputIndex).toString());
    }

    public static void updateContact(int contactId, String fieldName, String newValue) {
        Contact contact = contacts.get(contactId);
        contact.setFieldByName(fieldName, newValue);
        contact.setLastEditDateTime(LocalDateTime.now().withNano(0));
        contacts.set(contactId, contact);
        System.out.println("Contact saved.");
    }

    public static boolean deleteContact(int contactIndex) {
        boolean result = false;
        if (contacts.isEmpty()) {
            System.out.println("No contacts to delete!");
        } else {
            try {
                contacts.remove(contactIndex);
                System.out.println("Contact deleted!");
                result = true;
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
        }
        return result;
    }

    public static final void serialize() {
        if (null != filename) {
            try {
                Serialization.serialize(contacts, filename);
            } catch (IOException e) {
                System.out.println("Couldn't save contacts.");
            }
        }
    }

    public static void searchContact(String searchStr) {
        Pattern searchQuery = Pattern.compile(".*" + searchStr + ".*", Pattern.CASE_INSENSITIVE);
        List<Contact> searchResult = new ArrayList<>();
        for (Contact contact : contacts) {
            List<Field> fields = contact.getAllFieldNames();
            for (Field field : fields) {
                try {
                    field.setAccessible(true);
                    Object fieldValue = field.get(contact);
                    if (null != fieldValue && searchQuery.matcher(fieldValue.toString()).matches()) {
                        searchResult.add(contact);
                    }
                } catch (IllegalAccessException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        final int size = searchResult.size();
        System.out.printf("Found %d results:\n", size);
        for (int i = 0; i < size; i++) {
            searchResult.get(i).showContactsListItem(i + 1);
        }
    }
}
