package com.urlshortener.main.exception;

public class RecordNotFoundException extends UrlServiceException {

    public RecordNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
