package com.gotprint.noteapp.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gotprint.noteapp.entity.UserNotes;
import com.gotprint.noteapp.model.UserContext;
import com.gotprint.noteapp.model.UserNoteModel;
import com.gotprint.noteapp.security.auth.JwtAuthenticationToken;
import com.gotprint.noteapp.service.IUserNoteService;
/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 *
 */
@RestController
public class UserNoteEndPoint {
	final static Logger logger = Logger.getLogger(UserNoteEndPoint.class);
	
	@Autowired
	private IUserNoteService userNoteService;
	
	@RequestMapping(value="/api/usernotes/title/{title}", method=RequestMethod.GET)
    public ResponseEntity<List<UserNoteModel>>getNoteByTitle(@PathVariable("title") String title,JwtAuthenticationToken token) {
        UserContext context =  (UserContext) token.getPrincipal();
        List<UserNoteModel> noteList = userNoteService.getByTitle(title,context.getUsername());
        if (noteList.isEmpty()) {
			logger.debug("User Notes is Empty");
			return new ResponseEntity<List<UserNoteModel>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + noteList.size() + " User Notes");
		return new ResponseEntity<List<UserNoteModel>>(noteList, HttpStatus.OK);
    }
	
	@RequestMapping(value="/api/usernotes", method=RequestMethod.GET)
    public ResponseEntity<List<UserNoteModel>>getAllUserNotes(JwtAuthenticationToken token) {
        UserContext context =  (UserContext) token.getPrincipal();
        List<UserNoteModel> noteList = userNoteService.getAllUserNotes(context.getUsername());
        if (noteList.isEmpty()) {
			logger.debug("User Notes is Empty");
			return new ResponseEntity<List<UserNoteModel>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + noteList.size() + " User Notes");
		return new ResponseEntity<List<UserNoteModel>>(noteList, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/api/usernotes", method = RequestMethod.POST)
	public ResponseEntity<Void> addEmployee(@RequestBody UserNoteModel userNote,JwtAuthenticationToken token) {
		UserContext context =  (UserContext) token.getPrincipal();
		userNoteService.saveUserNote(userNote,context.getUsername());
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/api/usernotes", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@RequestBody UserNoteModel userNote,JwtAuthenticationToken token) {
		UserContext context =  (UserContext) token.getPrincipal();
		Optional<UserNotes> optional = userNoteService.getById(userNote.getId());
		if(optional.isPresent()){
			userNoteService.saveUserNote(userNote,context.getUsername());
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else{
			logger.debug("UserNote with id " + userNote.getId() + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/api/usernotes/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserNoteModel> getEmployee(@PathVariable("id") Long id,JwtAuthenticationToken token) {
		Optional<UserNotes> optional = userNoteService.getById(id);
		if(optional.isPresent()){
			UserNoteModel userNote = new UserNoteModel();
			BeanUtils.copyProperties(optional.get(), userNote);
			return new ResponseEntity<UserNoteModel>(userNote, HttpStatus.OK);
		}else{
			logger.debug("UserNote with id " + id + " does not exists");
			return new ResponseEntity<UserNoteModel>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/api/usernotes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id,JwtAuthenticationToken token) {
		Optional<UserNotes> optional = userNoteService.getById(id);
		if(optional.isPresent()){
			userNoteService.deleteById(id);
			logger.debug("UserNote with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}else{
			logger.debug("UserNote with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	
}
