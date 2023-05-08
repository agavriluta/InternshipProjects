package stage4;

import stage4.commandPattern.*;
import stage4.contactsFactory.Contact;
import stage4.contactsFactory.ContactType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

    public class Menu {
        public static void loadContacts(String[] args) {
            if (0 != args.length) {
                String filename = args[0];
                PhoneBook.setFilename(filename);
                try {
                    ArrayList<Contact> contacts = (ArrayList<Contact>) Serialization.deserialize(filename);
                    PhoneBook.setContacts(contacts);
                    System.out.printf("Loaded contacts from file: " + filename + "\n");
                } catch (ClassNotFoundException | IOException e) {
                    System.out.printf("No contacts loaded. New contacts will be saved to \"%s\"", filename + "\n");
                }
            }
        }

        public static void openMainMenuDialog() {
            boolean doNotExit = true;

            do {
                System.out.print("\n[menu] Enter action (add, list, search, count, exit): ");
                var action = Arrays.stream(ActionMenu.values())
                        .filter(enum1 -> enum1.getOption()
                                .equals(getUserInput().toUpperCase()))
                        .findFirst()
                        .orElse(ActionMenu.DEFAULT);
                switch (action) {
                    case ADD -> openAddMenu();
                    case LIST -> openListMenu();
                    case SEARCH -> search();
                    case COUNT -> System.out.printf("The Phone Book has %d records.\n", PhoneBook.getContactSize());
                    case EXIT -> doNotExit = false;
                    case DEFAULT -> System.out.println("Wrong input entered. Try again...");
                }
            } while (doNotExit);
        }

        private static void openAddMenu() {
            boolean doNotStop = false;
            do {
                System.out.print("\n[add] Enter the type (person, organization) or back: ");
                var action = Arrays.stream(ContactType.values())
                        .filter(enum1 -> enum1.getType()
                                .equals(getUserInput().toUpperCase()))
                        .findFirst()
                        .orElse(ContactType.DEFAULT);
                switch (action) {
                    case PERSON:
                        commandAddPerson();
                        break;
                    case ORGANIZATION:
                        commandAddOrganisation();
                        break;
                    case BACK:
                        break;
                    case DEFAULT:
                        System.out.println("Wrong input entered. Try again...");
                        doNotStop = true;
                        break;
                }
            } while (doNotStop);
        }

        private static void commandAddPerson() {
            Command addPerson = new addPersonCommand();
            addPerson.execute();
        }

        private static void commandAddOrganisation() {
            Command addOrganization = new addOrganizationCommand();
            addOrganization.execute();
        }

        private static void openListMenu() {
            if (0 == PhoneBook.getContactSize()) {
                System.out.println("No records to show!");
            } else {
                boolean doNotStop = false;
                String action;
                do {
                    PhoneBook.listContacts();
                    System.out.print("\n[list] Enter action ([number], back): ");
                    switch (action = getUserInput().toUpperCase()) {
                        case "":
                        case "NUMBER":
                            try {
                                contactById(getUserInput());
                                break;
                            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                System.out.println("Wrong input entered. Try again...");
                                break;
                            }
                        case "BACK":
                            break;
                        default:
                            try {
                                contactById(action);
                            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                System.out.println("Wrong input entered. Try again...");
                                doNotStop = true;
                            }
                    }
                } while (doNotStop);
            }
        }

        private static void contactById(String userInputId) {
            int contactId = Integer.parseInt(userInputId) - 1;
            commandShowContact(contactId);
            openContactMenu(contactId);
        }

        private static void commandShowContact(int contactId) {
            Command commandShow = new showCommand(contactId);
            commandShow.execute();
        }

        public static String getUserInput() {
            final Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }

        private static void openContactMenu(int contactId) {
            boolean doNotStop = true;
            do {
                System.out.print("\n[contact] Enter action (edit, delete, menu): ");
                switch (getUserInput().toUpperCase()) {
                    case "EDIT" -> {
                        Contact contact = PhoneBook.getContactById(contactId);
                        contact.showEditableFields();
                        String[] editableFields = contact.getEditableFields();
                        String fieldForUpdate = getUserInput().toUpperCase();
                        if (Arrays.asList(editableFields).contains(fieldForUpdate)) {
                            commandUpdate(contactId, fieldForUpdate);
                            commandShowContact(contactId);
                        } else {
                            System.out.println("Wrong input entered. Try again...");
                        }
                    }
                    case "DELETE" -> {
                        commandDelete(contactId);
                        doNotStop = false;
                    }
                    case "MENU" -> doNotStop = false;
                    default -> System.out.println("Wrong input entered. Try again...");
                }
            } while (doNotStop);
        }

        private static void commandUpdate(int contactId, String fieldForUpdate) {
            System.out.println("Enter " + fieldForUpdate.toLowerCase());
            Command commandUpdate = new updateCommand(contactId, fieldForUpdate, getUserInput());
            commandUpdate.execute();
        }

        private static void commandDelete(int contactId) {
            Command commandDelete = new deleteCommand(contactId);
            commandDelete.execute();
        }

        private static void search() {
            if (0 == PhoneBook.getContactSize()) {
                System.out.println("No records to search!");
            } else {
                System.out.print("Enter search query: ");
                commandSearch();
                openSearchMenu();
            }
        }

        private static void commandSearch() {
            Command commandSearch = new searchCommand(getUserInput());
            commandSearch.execute();
        }

        private static void openSearchMenu() {
            boolean doNotExit = false;
            Scanner scan = new Scanner(System.in);
            var input = scan.nextLine();
            var action = Arrays.stream(SearchMenu.values())
                    .filter(enum1 -> enum1.getOption()
                            .equals(input.toUpperCase()))
                    .findFirst()
                    .orElse(SearchMenu.DEFAULT);
            do {
                System.out.print("[search] Enter action ([number], back, again): ");
                switch (action) {
                    case NUMBER:
                        contactById(scan.nextLine());
                        break;
                    case BACK:
                        break;
                    case AGAIN:
                        search();
                        break;
                    case DEFAULT:
                        try {
                            contactById(scan.nextLine());
                        } catch (NumberFormatException | IndexOutOfBoundsException e) {
                            System.out.println("Wrong input entered. Try again...");
                            doNotExit = true;
                        }
                }

            } while (doNotExit);

        }
    }

