package stage4.commandPattern;

import stage4.PhoneBook;

public class deleteCommand implements Command {
    private final int contactId;

    public deleteCommand( int contactId) {
        this.contactId = contactId;
    }

    @Override
    public final void execute() {
        if (PhoneBook.deleteContact(contactId)) {
            PhoneBook.serialize();
        }
    }
}
