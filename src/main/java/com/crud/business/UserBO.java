package com.crud.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crud.models.UserMO;
import com.crud.repositories.UserRE;

@Component
public class UserBO {
	
	@Autowired
	private UserRE userRE;
	
	public UserBO(UserRE userRepository) {
		this.userRE = userRepository;
	}
	
	public Iterable<UserMO> findAll() throws Exception{
		return (Iterable<UserMO>) userRE.findAll();
	}
	
	public Optional<UserMO> findById(long id) throws Exception{
		return userRE.findById(id);
	}
	
	public UserMO save(UserMO user) throws Exception{
		return userRE.saveAndFlush(user);
	}
	
	public UserMO update(long id, UserMO user) throws Exception{
		user.setId(id);
		return userRE.saveAndFlush(user);
	}
	
	public void deleteById(Long id) throws Exception, IllegalArgumentException{
		userRE.deleteById(id);
	}
}
