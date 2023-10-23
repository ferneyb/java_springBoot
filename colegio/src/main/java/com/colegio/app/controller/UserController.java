package com.colegio.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.app.entity.User;
import com.colegio.app.service.UserService;

@SuppressWarnings("unused")
@RestController
//@RequestMapping(value="/api/users", method = { RequestMethod.GET, RequestMethod.POST })
@RequestMapping(value="/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//create a new user
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.safe(user));
	}
	//read an user
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value="id") Long idUser){
		Optional<User> optionalUser=userService.findById(idUser);
		
		if(!optionalUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(idUser);
		
	}
	//update
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userdUser,@PathVariable(value="id") Long idUser){
		Optional<User> user=userService.findById(idUser);
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//BeanUtils.copyProperties(userdUser, user.get());
		user.get().setNames(userdUser.getNames());
		user.get().setSurname(userdUser.getSurname());
		user.get().setEmail(userdUser.getEmail());
		user.get().setEnabled(userdUser.getEnabled());
		user.get().setTelefono(userdUser.getTelefono());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.safe(user.get()));
	}
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(value="id") Long userID){
		if(!userService.findById(userID).isPresent()) {
			return ResponseEntity.notFound().build();		
			}
		userService.deleteById(userID);
		return ResponseEntity.ok().build();
	}
	//reading all users
	@GetMapping
	public List<User> readAll(){
		List<User> users = StreamSupport
				.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return users;
	}

}
