package com.gotprint.noteapp.common;

import com.fasterxml.jackson.annotation.JsonValue;
/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 * Enumeration of REST Error types.
 *
 */
public enum ErrorCode {
    GLOBAL(2),

    AUTHENTICATION(10), JWT_TOKEN_EXPIRED(11);
    
    private int errorCode;

    private ErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @JsonValue
    public int getErrorCode() {
        return errorCode;
    }
}
