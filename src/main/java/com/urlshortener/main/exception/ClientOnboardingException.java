package com.urlshortener.main.exception;

public class ClientOnboardingException extends UrlServiceException {

    public ClientOnboardingException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

}
