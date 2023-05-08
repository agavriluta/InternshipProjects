package stage4.commandPattern;

import stage4.PhoneBook;
public class searchCommand implements Command {
    private final String searchString;
    public searchCommand(String searchString) {
        this.searchString = searchString;
    }
    @Override
    public final void execute() {
        PhoneBook.searchContact(searchString);
    }
}
