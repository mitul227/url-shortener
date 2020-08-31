package com.urlshortener.main.exception;

public class UrlServiceException extends RuntimeException {

    protected ErrorCode errorCode;

    public UrlServiceException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

}
