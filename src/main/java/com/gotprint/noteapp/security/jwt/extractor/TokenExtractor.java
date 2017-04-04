package com.gotprint.noteapp.security.jwt.extractor;

 /**
 * Implementations of this interface should always return raw base-64 encoded
 * representation of JWT Token.
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 *
 */
public interface TokenExtractor {
    public String extract(String payload);
}
