package stage4.commandPattern;

import stage4.PhoneBook;

public class showCommand implements Command {
    private int contactId;

    private showCommand() {
    }

    public showCommand(int contactId) {
        this.contactId = contactId;
    }

    @Override
    public final void execute() {
        PhoneBook.showContact(contactId);
    }
}
