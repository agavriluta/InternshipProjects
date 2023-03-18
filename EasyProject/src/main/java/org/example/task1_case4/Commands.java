package org.example.task1_case4;

public enum Commands{
    DOUBLE_USER("start user user"),
    AI_USER("start easy user"),
    USER_AI("start user easy"),
    AI("start easy easy"),
    M_AI_USER("start medium user"),
    M_USER_AI("start user medium"),
    EXIT("exit");
    private final String field;
    Commands(String field){
        this.field = field;
    }
    public String getField(){
        return this.field;
    }
}
