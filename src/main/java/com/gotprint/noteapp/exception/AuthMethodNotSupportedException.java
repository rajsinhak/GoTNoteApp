package com.gotprint.noteapp.exception;

import org.springframework.security.authentication.AuthenticationServiceException;
/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 * Custom Exception
 *
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    private static final long serialVersionUID = 3705043083010304496L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
