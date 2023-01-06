package com.adilcodes.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class UserDetailsEmptyException extends Exception {

    private String msg;

    public UserDetailsEmptyException() {
    }

    public UserDetailsEmptyException(String msg) {
        super(msg);
        this.msg = msg;
    }


}
