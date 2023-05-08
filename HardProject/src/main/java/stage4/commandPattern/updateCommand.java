package stage4.commandPattern;

import stage4.PhoneBook;

public class updateCommand implements Command {
    private int contactId;
    private String fieldForUpdate;
    private String newValue;

    private updateCommand() {
    }

    public updateCommand( int contactId, String fieldForUpdate, String newValue) {
        this.contactId = contactId;
        this.fieldForUpdate = fieldForUpdate;
        this.newValue = newValue;
    }

    @Override
    public final void execute() {
        PhoneBook.updateContact(contactId, fieldForUpdate, newValue);
        PhoneBook.serialize();
    }
}