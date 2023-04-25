package stage4;

public class Person {
    private String firstName;
    private String lastName;
    private String email;

    public Person() {
    }

    public Person(String firstName) {
        this.firstName = firstName;
        this.lastName = "";
        this.email = "";
    }

    public Person(String firstName, String lastName) {
        this(firstName);
        if (lastName != null) {
            this.lastName = lastName;
        }
    }

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        if (lastName != null) {
            this.lastName = lastName;
        }
        if (email != null) {
            this.email = email;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        if (email.isBlank()) return firstName + " " + lastName;
        else return firstName + " " + lastName + " " + email;
    }
}
