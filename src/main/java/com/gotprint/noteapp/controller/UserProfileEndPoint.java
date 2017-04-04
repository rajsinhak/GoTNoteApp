package com.gotprint.noteapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gotprint.noteapp.model.UserContext;
import com.gotprint.noteapp.security.auth.JwtAuthenticationToken;

/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 *
 */

@RestController
public class UserProfileEndPoint {
	@RequestMapping(value="/api/user", method=RequestMethod.GET)
    public @ResponseBody UserContext get(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }
}
