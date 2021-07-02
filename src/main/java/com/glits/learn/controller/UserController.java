package com.glits.learn.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glits.learn.dto.ErrorResp;
import com.glits.learn.dto.SuccessResp;
import com.glits.learn.dto.UserReq;
import com.glits.learn.model.Users;
import com.glits.learn.repository.UsersRepo;

@RestController
@RequestMapping(path = "/user")
public class UserController {
	@Autowired
	UsersRepo usersRepo;

	@GetMapping("/getall")
	public ResponseEntity<?> getAllUser() {
		List<Users> users = usersRepo.findAll();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<?> getUserByID(@PathVariable("id") Integer id) {
		Optional<Users> user = usersRepo.findById(id);
		if (user.isEmpty()) {
			return new ResponseEntity<ErrorResp>(new ErrorResp("User Tidak Ditemukan"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(user);
	}

	@PostMapping(path = "/add", consumes = "application/json")
	public ResponseEntity<?> addMessage(@RequestBody UserReq payload) {
		Users user = usersRepo.findByEmail(payload.getEmail());
		if (user != null) {
			return new ResponseEntity<ErrorResp>(new ErrorResp("Email Sudah Dipakai"), HttpStatus.BAD_REQUEST);
		}
		
		user = new Users(payload.getName(), payload.getAddress(), payload.getEmail());
		try {
			usersRepo.save(user);
		} catch (Exception e) {
			return new ResponseEntity<ErrorResp>(new ErrorResp(e.getMessage()), 
				HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(new SuccessResp("User berhasil ditambah", 200));
	}
}
