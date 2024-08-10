package com.sujeet.brainbuster.exception;


public class QuestionNotFoundError extends RuntimeException {
    public QuestionNotFoundError(String message) {
        super(message);
    }
}
