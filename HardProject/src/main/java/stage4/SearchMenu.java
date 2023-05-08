package stage4;

public enum SearchMenu {
    NUMBER("NUMBER"),
    BACK("BACK"),
    AGAIN("AGAIN"),
    DEFAULT("DEFAULT");

    private final String option;
    private SearchMenu(String option){
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
