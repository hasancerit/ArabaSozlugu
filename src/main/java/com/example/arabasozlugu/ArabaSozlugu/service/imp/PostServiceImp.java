package com.example.arabasozlugu.ArabaSozlugu.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.post.PostReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.post.PostResDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.user.UserResDTO;
import com.example.arabasozlugu.ArabaSozlugu.model.Post;
import com.example.arabasozlugu.ArabaSozlugu.model.User;
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
		User user = userRepo.findById(post.getUserId()).get();
		postEnt.setUser(user);
		postEnt.getCar().setUser(user);
		postEnt = postRepo.save(postEnt);
		return modelMapper.map(postEnt,PostResDTO.class);
	}

	@Override
	public PostResDTO getPost(String id) {
		Post post = postRepo.findById(id).get();
		if(post == null) {
			
		}
		PostResDTO ret = modelMapper.map(post,PostResDTO.class);
		ret.setUserId();
		return ret;
	}

	@Override
	public List<PostResDTO> getAll() {
		List<Post> posts = postRepo.findAll();
		List<PostResDTO> postR = new ArrayList<PostResDTO>();
		for(Post p : posts) {
			PostResDTO prd = modelMapper.map(p,PostResDTO.class);
			prd.setUserId();
			postR.add(prd);
		}
		return postR;
	}

	@Override
	public PostResDTO delete(String id) {
		Post post = postRepo.findById(id).get();
		postRepo.delete(post);
		
		PostResDTO ret = modelMapper.map(post,PostResDTO.class);
		ret.setUserId();
		return ret;
	}
}
