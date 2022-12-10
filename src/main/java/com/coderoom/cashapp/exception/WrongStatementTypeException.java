package com.coderoom.cashapp.exception;

public class WrongStatementTypeException extends RuntimeException {
    public WrongStatementTypeException(){
        super();
    }
    public WrongStatementTypeException(String message){
        super(message);
    }
}
