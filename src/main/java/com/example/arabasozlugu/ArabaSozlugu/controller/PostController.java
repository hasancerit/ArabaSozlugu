package com.example.arabasozlugu.ArabaSozlugu.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.post.PostReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.post.PostResDTO;
import com.example.arabasozlugu.ArabaSozlugu.service.PostService;


@RestController
@RequestMapping("/post")
public class PostController {
	@Autowired
	PostService postService;
	
	@PostMapping("addPost")
	public ResponseEntity<PostResDTO> addPost(@Valid @RequestBody PostReqDTO post){
		return new ResponseEntity<PostResDTO>(postService.addPost(post),HttpStatus.OK);
	}
}
