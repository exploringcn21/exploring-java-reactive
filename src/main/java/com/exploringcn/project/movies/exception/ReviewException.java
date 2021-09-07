package com.exploringcn.project.movies.exception;

public class ReviewException extends RuntimeException {
    String message;
    public ReviewException(String message) {
        super(message);
        this.message = message;
    }
}