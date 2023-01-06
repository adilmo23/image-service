package com.adilcodes.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserNameNotFoundException extends Exception {

    private String msg;

    public UserNameNotFoundException() {
    }

    public UserNameNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
