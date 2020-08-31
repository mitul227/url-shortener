package com.urlshortener.main.exception;

public class InvalidLongUrlException extends UrlServiceException {

    public InvalidLongUrlException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
