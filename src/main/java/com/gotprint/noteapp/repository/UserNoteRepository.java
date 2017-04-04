package com.gotprint.noteapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gotprint.noteapp.entity.UserNotes;

/**
 * @author Raj Kamal
 * @since 04/04/2017
 * UserNoteRepository Performs UserNote Crud Operations
 */
@Repository
public interface UserNoteRepository extends JpaRepository<UserNotes, Long> {

	@Query("select un from UserNotes un where UPPER(un.title) LIKE CONCAT('%',UPPER(:title),'%') and UPPER(un.userId.username) = UPPER(:username)")
    public List<UserNotes> findByTitle(@Param("title") String title,@Param("username") String username);
	
	@Query("select un from UserNotes un where un.id=:id")
    public Optional<UserNotes> findById(@Param("id") Long id);
	
	@Query("select un from UserNotes un where un.userId.username = :username")
    public List<UserNotes> findAllUserNotes(@Param("username") String username);
}
