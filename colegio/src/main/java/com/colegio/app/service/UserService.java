package com.colegio.app.service;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.colegio.app.entity.User;

public interface UserService {
	public  Iterable<User> findAll();
	public Page<User> findAll(Pageable pageable);
	public Optional<User> findById(Long id);
	public User safe(User user);
	public void deleteById(Long id);
	
}
