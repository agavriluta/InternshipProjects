package stage3;

public class People extends Contacts {
    private String name;
    private String surname;
    private String gender;
    private String birthDate;


    public People() {
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        boolean checkBirthDate = Validator.checkBirthDate(birthDate);
        if (!checkBirthDate) {
            System.out.println("Bad birth date!");
            this.birthDate = "[no data]";
        }
        else this.birthDate = birthDate;

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        boolean checkGender = Validator.checkGender(gender);
        if (!checkGender) {
            System.out.println("Bad gender!");
            this.gender = "[no data]";
        }
        else this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Surname: " + surname + "\n" +
                "Birth date: " + birthDate + "\n" +
                "Gender: " + gender + "\n" +
                "Number: " + number + "\n" +
                "Time created: " + creation + "\n" +
                "Time last edit: " + edition ;
    }

    @Override
    public String getFullName() {
        return name.concat(" ").concat(surname);
    }
}
