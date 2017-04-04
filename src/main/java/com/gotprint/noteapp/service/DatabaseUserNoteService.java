package com.gotprint.noteapp.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gotprint.noteapp.entity.User;
import com.gotprint.noteapp.entity.UserNotes;
import com.gotprint.noteapp.model.UserNoteModel;
import com.gotprint.noteapp.repository.UserNoteRepository;

 /**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 *
 */
@Service
public class DatabaseUserNoteService implements IUserNoteService {
	final static Logger logger = Logger.getLogger(DatabaseUserNoteService.class);
	private final UserNoteRepository userNoteRepository;
	private final DatabaseUserService userService;
	@Autowired
	public DatabaseUserNoteService(UserNoteRepository userNoteRepository,DatabaseUserService userService) {
		this.userNoteRepository = userNoteRepository;
		this.userService = userService;
	}

	public UserNoteRepository getUserNoteRepository() {
		return userNoteRepository;
	}
	@Override
	public List<UserNoteModel> getByTitle(String title, String userId) {
		return convertEntityToModel(this.userNoteRepository.findByTitle(title, userId));
	}

	@Override
	public List<UserNoteModel> getAllUserNotes(String userId) {
		return convertEntityToModel(this.userNoteRepository.findAllUserNotes(userId));
	}

	@Override
	public void deleteById(Long id) {
		this.userNoteRepository.delete(id);
	}

	@Override
	public Optional<UserNotes> getById(Long id) {
		return this.userNoteRepository.findById(id);
	}
	private List<UserNoteModel> convertEntityToModel(List<UserNotes> notes){
		List<UserNoteModel> noteList = new ArrayList<>();
		Iterator<UserNotes> iterate = notes.iterator();
		logger.info("No Of Records Fetched :: "+notes.size());
		while(iterate.hasNext()){
			UserNotes note = iterate.next();
			UserNoteModel model = new UserNoteModel();
			BeanUtils.copyProperties(note, model);
			noteList.add(model);
		}
		return noteList;
	}

	@Override
	public UserNotes saveUserNote(UserNoteModel userNote,String username) {
		Optional<User> optional = this.userService.getByUsername(username);
		UserNotes note = new UserNotes();
		BeanUtils.copyProperties(userNote, note);
		if(note.getId() == null)
			note.setCreateDate(new Date(System.currentTimeMillis()));
		else
			note.setUpdateDate(new Date(System.currentTimeMillis()));
		note.setUserId(optional.get());
		return this.userNoteRepository.save(note);
	}
	
}
