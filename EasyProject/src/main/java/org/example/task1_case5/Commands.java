package org.example.task1_case5;

    public enum Commands {
        DOUBLE_USER("start user user"),
        AI_USER("start easy user"),
        USER_AI("start user easy"),
        AI("start easy easy"),
        M_AI_USER("start medium user"),
        M_USER_AI("start user medium"),
        H_AI_USER("start hard user"),
        H_USER_AI("start user hard"),
        H_AI("start hard hard"),
        EXIT("exit"),
        DEFAULT("default");
        private final String field;
        Commands(String field){
            this.field = field;
        }
        public String getField(){
            return this.field;
        }
    }

