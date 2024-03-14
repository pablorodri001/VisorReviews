package com.liceo.di.exameord.facade;

public class InvalidIdReviewException extends Exception {

    public InvalidIdReviewException(){}

    public InvalidIdReviewException(String message){
        super(message);
    }

    public InvalidIdReviewException(Throwable cause){
        super(cause);
    }

    public InvalidIdReviewException(String message, Throwable cause){
        super(message, cause);
    }
}
