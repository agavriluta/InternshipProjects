package stage2;

import java.util.Scanner;

public class Contacts {
    private String name;
    private String surname;
    private String number = null;

    public Contacts() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name of the person:");
        this.name = scan.nextLine();
        System.out.println("Enter the surname of the person:");
        this.surname = scan.nextLine();
        System.out.println("Enter the number:");
        this.number = scan.nextLine();
    }

    public Contacts(String name, String surname, String number) {
        this.name = name;
        this.surname = surname;
        if (CheckNumber.isValid(this , number)){
            this.number = number;
        }
        else {
            System.out.println("Wrong number format!");
        }

    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean hasNumber(){
        return number != null;
    }

    @Override
    public String toString() {
        if (number == null) number = "[no number]";
        return " " + name + " " + surname + ", " + number;
    }

    public static class ContactsBuilder implements Builder{
        private String name;
        private String surname;
        private String number;

        public ContactsBuilder() {
        }
        @Override
        public void setName(String name) {
            this.name = name;

        }
        @Override
        public void setSurname(String surname) {
            this.surname = surname;
        }
        @Override
        public void setNumber(String number) {
            this.number = number;
        }

        @Override
        public Contacts build() {
            return new Contacts(name,surname,number);
        }

    }
}
