package com.example.arabasozlugu.ArabaSozlugu.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.LoginUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.SingupUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.UserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.user.JWTUserResDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.user.UserResDTO;
import com.example.arabasozlugu.ArabaSozlugu.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
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
	public ResponseEntity<JWTUserResDTO> login(@Valid @RequestBody LoginUserReqDTO user){
		return new ResponseEntity<JWTUserResDTO>(userService.login(user),HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<UserResDTO> getUser(@PathVariable String id){
		return new ResponseEntity<UserResDTO>(userService.getUser(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserResDTO>> getAll(){
		return new ResponseEntity<List<UserResDTO>> (userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<UserResDTO> deleteUser(@PathVariable String id){
		return new ResponseEntity<UserResDTO> (userService.deleteUser(id),HttpStatus.OK);
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<UserResDTO> updateUser(@RequestBody UserReqDTO user,@PathVariable String id){
		return new ResponseEntity<UserResDTO> (userService.updateUser(user, id),HttpStatus.OK);
	}
	
	@GetMapping("/findByPost/{postId}")
	public ResponseEntity<UserResDTO> findUserById(@PathVariable String postId){
		return new ResponseEntity<UserResDTO> (userService.findUserByPost(postId),HttpStatus.OK);
	}
}

