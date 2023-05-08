package stage4.contactsFactory;
import java.util.Arrays;

public class OrganizationContact extends Contact {
    private static final long serialVersionUID = -414925866745458581L;
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFieldByName(String fieldName, String newValue) {
        switch (fieldName) {
            case "NAME" -> name = newValue;
            case "ADDRESS" -> address = newValue;
            case "NUMBER" -> number = filterPhoneNumber(newValue);
        }
    }

    @Override
    public String[] getEditableFields() {
        return Arrays.stream(OrganizationContact.EditableFields.values()).map(Enum::toString).toArray(String[]::new);
    }

    @Override
    public void showContactsListItem(int index) {
        System.out.println(index +" ." + name+"\n");
    }

    @Override
    public void showEditableFields() {
        System.out.print("\nSelect a field (name, address, number): ");
    }

    @Override
    public String toString() {
        String currentNumber = number.isBlank() ? "[no number]" : number;
        return String.format("Organization name: %s%nAddress: %s%nNumber: %s%nTime created: %s%nTime last edit: %s%n",
                name, address, currentNumber, creationDateTime, lastEditDateTime);
    }

    enum EditableFields {
        NAME, ADDRESS, NUMBER
    }
}
