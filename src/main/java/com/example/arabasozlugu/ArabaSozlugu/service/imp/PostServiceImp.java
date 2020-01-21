package com.example.arabasozlugu.ArabaSozlugu.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.PostReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.PostResDTO;
import com.example.arabasozlugu.ArabaSozlugu.model.Post;
import com.example.arabasozlugu.ArabaSozlugu.repo.PostRepo;
import com.example.arabasozlugu.ArabaSozlugu.repo.UserRepo;
import com.example.arabasozlugu.ArabaSozlugu.service.PostService;

@Service
public class PostServiceImp implements PostService{
	PostRepo postRepo;
	UserRepo userRepo;
	ModelMapper modelMapper;
	
	@Autowired
	public PostServiceImp(PostRepo postRepo,ModelMapper modelMapper,UserRepo userRepo) {
		this.postRepo = postRepo;
		this.modelMapper = modelMapper;
		this.userRepo = userRepo;
	}
	
	@Override
	public PostResDTO addPost(PostReqDTO post){
		Post postEnt = modelMapper.map(post, Post.class);
		postEnt.setUser(userRepo.findById(post.getUserId()).get());
		postEnt = postRepo.save(postEnt);
		return modelMapper.map(postEnt,PostResDTO.class);
	}
}
