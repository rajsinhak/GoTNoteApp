package com.gotprint.noteapp.service;

import java.util.List;
import java.util.Optional;

import com.gotprint.noteapp.entity.UserNotes;
import com.gotprint.noteapp.model.UserNoteModel;

public interface IUserNoteService {
	public List<UserNoteModel> getByTitle(String title, String userId);
	public Optional<UserNotes> getById(Long id);
	public List<UserNoteModel> getAllUserNotes(String userId);
	public void deleteById(Long userId);
	public UserNotes saveUserNote(UserNoteModel userNote,String username);
}
