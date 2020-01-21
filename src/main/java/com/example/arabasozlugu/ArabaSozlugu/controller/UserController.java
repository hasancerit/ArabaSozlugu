package com.example.arabasozlugu.ArabaSozlugu.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.LoginUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.SingupUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.UserResDTO;
import com.example.arabasozlugu.ArabaSozlugu.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/signup")
	public ResponseEntity<UserResDTO> signUp( @Valid @RequestBody SingupUserReqDTO user){
		return new ResponseEntity<UserResDTO>(userService.signup(user),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserResDTO> login(@Valid @RequestBody LoginUserReqDTO user){
		return new ResponseEntity<UserResDTO>(userService.login(user),HttpStatus.OK);
	}
}
