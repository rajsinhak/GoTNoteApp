package com.gotprint.noteapp.model;

import java.sql.Date;
/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 *
 */
public class UserNoteModel {
	private Long id;
	private String title;
	private String note;
	private Date createDate;
	private Date updateDate;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
	
}
