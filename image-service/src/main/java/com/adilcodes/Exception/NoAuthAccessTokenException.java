package com.adilcodes.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class NoAuthAccessTokenException extends RuntimeException {

    private String msg;

    public NoAuthAccessTokenException() {
    }

    public NoAuthAccessTokenException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
