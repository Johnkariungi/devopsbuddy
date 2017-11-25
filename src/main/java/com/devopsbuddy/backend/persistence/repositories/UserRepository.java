package com.devopsbuddy.backend.persistence.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devopsbuddy.backend.persistence.domain.backend.User;

@Repository
@Transactional(readOnly = true)/* since it's a method that updates the DB using @Query annotation. */
public interface UserRepository extends CrudRepository<User, Long>{
	
	/** 
	 * Returns a User given a username or null if not found.
	 * @param username The username
	 * @return a user given a username or null if not found.
	 */
	public User findByUsername(String username);
	
	 /**
     * Returns a User for the given email or null if none was found.
     * @param email The user's email
     * @return a User for the given email or null if none was found.
     */
	public User findByEmail(String email);
	
	@Transactional
	@Modifying/* to the JPA engine - means the state of the database will change.*/
	@Query("update User u set u.password = :password where u.id = :userId")
	/* @Param are the arguments instead of ?parameter and can be passed at any order.*/
	void updateUserPassword(@Param("userId") long userId, @Param("password") String password); 
}
