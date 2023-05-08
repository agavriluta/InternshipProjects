package stage4.commandPattern;

import stage4.PhoneBook;

public class addPersonCommand implements Command {
    public addPersonCommand() {
    }

    @Override
    public final void execute() {
        PhoneBook.addPerson();
        PhoneBook.serialize();
    }
}
