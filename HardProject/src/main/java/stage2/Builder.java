package stage2;

public interface Builder {
    public void setName(String name);

    public void setSurname(String surname);

    public void setNumber(String number);
    public Contacts build();
}
