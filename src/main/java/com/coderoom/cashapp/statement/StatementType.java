package com.coderoom.cashapp.statement;

public enum StatementType {
    DEBIT(100) , CREDIT(1);

    Integer value;
    StatementType(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return this.value;
    }
}
