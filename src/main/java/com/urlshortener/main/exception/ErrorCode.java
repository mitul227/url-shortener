package com.urlshortener.main.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    client_already_exists(HttpStatus.BAD_REQUEST),
    invalid_client_id(HttpStatus.BAD_REQUEST),
    invalid_long_url(HttpStatus.BAD_REQUEST),
    long_url_not_found(HttpStatus.NOT_FOUND),
    short_url_not_found(HttpStatus.NOT_FOUND),
    something_went_wrong(HttpStatus.INTERNAL_SERVER_ERROR);

    private HttpStatus httpStatus;

    ErrorCode(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
