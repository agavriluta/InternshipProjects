package stage4.commandPattern;

import stage4.PhoneBook;

public class addOrganizationCommand implements Command {

    public addOrganizationCommand() {
    }

    @Override
    public final void execute() {
        PhoneBook.addOrganization();
        PhoneBook.serialize();
    }
}