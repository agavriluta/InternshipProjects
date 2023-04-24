package org.example.task1_case5;

public enum Player {
    X('X'),
    O('O');
    private final char field;
    Player(char field){
        this.field = field;
    }
    public char getField(){
        return this.field;
    }
}
