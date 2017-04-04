package com.gotprint.noteapp.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
/**
 * 
 * @author Raj Kamal
 * @since 04/04/2017
 *
 */
@Entity
@Table(name="APP_USER")
public class User implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

	@Id @Column(name="USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 100)
    @Email
    @Column(name="email_id",unique = true)
    private String username;
    
    @NotNull
    @Column(name="password")
    private String password;
    
    @Column(name="CREATE_TIME")
    private Date createDate;
    
    @Column(name="UPDATE_TIME")
    private Date updateDate;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId",fetch=FetchType.LAZY)
    private Set<UserNotes> userNotes;
    
    public User(){};
	public User(Long id, String username, String password, Date createDate, Date updateDate) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}
	
	public Set<UserNotes> getUserNotes() {
		return userNotes;
	}
	
   
}
