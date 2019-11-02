package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.domain.User;
import com.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements CrudInterface<User> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> save(User entity) {
		
		return Optional.ofNullable(userRepository.save(entity));
	}

	@Override
	public Optional<User> findById(long id) {
			return userRepository.findById(id);
	}

	@Override
	public void delete(User entity) {
			userRepository.delete(entity);
	}
 
}
