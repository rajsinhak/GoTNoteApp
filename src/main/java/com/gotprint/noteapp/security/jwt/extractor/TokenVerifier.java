package com.gotprint.noteapp.security.jwt.extractor;

/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 *
 */
public interface TokenVerifier {
    public boolean verify(String jti);
}
