package com.gotprint.noteapp.security.jwt.extractor;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 *
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
