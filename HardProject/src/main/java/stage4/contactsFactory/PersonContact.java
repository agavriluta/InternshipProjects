package stage4.contactsFactory;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

public class PersonContact extends Contact {
    private static final long serialVersionUID = 3725973772164558564L;
    private String surname;
    private LocalDate birthDate;
    private Gender gender;

    void setSurname(String surname) {
        this.surname = surname;
    }

    void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public void setFieldByName(String fieldName, String newValue) {
        switch (fieldName) {
            case "NAME" -> name = newValue;
            case "SURNAME" -> surname = newValue;
            case "BIRTHDATE" -> birthDate = tryCastStrToDate(newValue);
            case "GENDER" -> gender = tryCastStrToGender(newValue);
            case "NUMBER" -> number = filterPhoneNumber(newValue);
        }
    }

    LocalDate tryCastStrToDate(CharSequence inputDate) {
        LocalDate result = null;
        try {
            result = LocalDate.parse(inputDate);
        } catch (DateTimeParseException e) {
            System.out.println("Bad date given!");
        }
        return result;
    }

    Gender tryCastStrToGender(String inputGender) {
        Gender result = null;
        try {
            result = Gender.valueOf(inputGender);
        } catch (IllegalArgumentException e) {
            System.out.println("Bad gender given!");
        }
        return result;
    }

    @Override
    public final String[] getEditableFields() {
        return Arrays.stream(PersonContact.EditableFields.values()).map(Enum::toString).toArray(String[]::new);
    }

    @Override
    public final void showEditableFields() {
        System.out.println("\nSelect a field (name, surname, birth, gender, number): ");
    }

    @Override
    public final void showContactsListItem(int index) {
        System.out.println("\n" + index + "." + name + " " + surname);
    }

    @Override
    public final String toString() {
        String currentBirthDate = null == birthDate ? "[no data]" : birthDate.toString();
        String currentGender = null == gender ? "[no data]" : gender.toString();
        String currentNumber = number.isBlank() ? "[no number]" : number;
        return String.format(
                "Name: %s%nSurname: %s%nBirth date: %s%nGender: %s%nNumber: %s%nTime created: %s%nTime last edit: %s%n",
                name, surname, currentBirthDate, currentGender, currentNumber, creationDateTime, lastEditDateTime
        );
    }

    enum Gender {
        M, F
    }

    public enum EditableFields {
        NAME, SURNAME, BIRTHDATE, GENDER, NUMBER
    }
}
