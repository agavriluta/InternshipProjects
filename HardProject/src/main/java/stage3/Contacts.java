package stage3;

import java.time.LocalDateTime;


public abstract class Contacts {
    String number;
    LocalDateTime creation;
    LocalDateTime edition;

    public Contacts() {
        creation = LocalDateTime.now().withSecond(0).withNano(0);
        edition = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        boolean checkNumber = Validator.checkNumber(number);
        if (!checkNumber) {
            System.out.println("Wrong number format!");
            this.number = "[no data]";
        }
        this.number = number;
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    public LocalDateTime getEdition() {
        return edition;
    }

    public void setEdition(LocalDateTime time) {
        this.edition = time;
    }

    public abstract String getFullName();
}

