package stage4.contactsFactory;

public enum ContactType {
    PERSON("PERSON"),
    ORGANIZATION("ORGANIZATION"),
    BACK("BACK"),
    DEFAULT("DEFAULT");
    private final String type;
    ContactType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
