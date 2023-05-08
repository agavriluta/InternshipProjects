package stage4;

public enum ActionMenu {
    ADD("ADD"),
    LIST("LIST"),
    SEARCH("SEARCH"),
    COUNT("COUNT"),
    EXIT("EXIT"),
    DEFAULT("DEFAULT");

    private final String action;
    private ActionMenu(String action){
        this.action = action;
    }

    public String getOption() {
        return action;
    }
}
