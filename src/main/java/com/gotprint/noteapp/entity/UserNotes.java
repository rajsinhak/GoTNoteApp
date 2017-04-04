package com.gotprint.noteapp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 *
 */
@Entity
@Table(name = "APP_USER_NOTES")
public class UserNotes implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "title")
	private String title;
	
	@Size(min = 1, max = 1000)
	@Column(name = "note")
	private String note;

	@Column(name = "CREATE_TIME")
	private Date createDate;

	@Column(name = "UPDATE_TIME")
	private Date updateDate;
	
	@JoinColumn(name = "USER_EMAIL_ID", referencedColumnName = "email_id")
    @ManyToOne(optional = false,fetch=FetchType.LAZY)
    private User userId;
	
	public UserNotes(){};
	
	public UserNotes(Long id, String title, String note, Date createDate, Date updateDate, User userId) {
		this.id = id;
		this.title = title;
		this.note = note;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getNote() {
		return note;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public User getUserId() {
		return userId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	
	
}
