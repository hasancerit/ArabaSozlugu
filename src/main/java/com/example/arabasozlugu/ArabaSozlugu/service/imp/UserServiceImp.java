package com.example.arabasozlugu.ArabaSozlugu.service.imp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.LoginUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.SingupUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.UserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.user.UserResDTO;
import com.example.arabasozlugu.ArabaSozlugu.exceptions.UserNotFoundException;
import com.example.arabasozlugu.ArabaSozlugu.model.User;
import com.example.arabasozlugu.ArabaSozlugu.repo.UserRepo;
import com.example.arabasozlugu.ArabaSozlugu.service.UserService;

@Service
public class UserServiceImp implements UserService{
	UserRepo userRepo;
	ModelMapper modelMapper;
	
	@Autowired
	public UserServiceImp(UserRepo userRepo,ModelMapper modelMapper) {
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
	}
	
	@Override
	public UserResDTO signup(SingupUserReqDTO user){
		User userEnt = userRepo.save(modelMapper.map(user,User.class));
		try {
			userEnt = userRepo.save(userEnt);
		}catch (Exception e) {
			return null;
		}
		UserResDTO userResp = modelMapper.map(userEnt,UserResDTO.class); 
		return userResp;
	}
	
	@Override
	public UserResDTO login(LoginUserReqDTO user) {
		User userEnt = null;
		try {
			userEnt = userRepo.findByUser(user.getUser());
		}catch (Exception e) {
			System.out.println("TEST");
		}
		if(userEnt == null) {
			throw new UserNotFoundException("Gecersiz Username",user);
		}
		
		return modelMapper.map(userEnt,UserResDTO.class);
	}
	
	@Override
	public UserResDTO getUser(String id) {
		User user = userRepo.findById(id).get();
		System.out.println(user.getCars().size());
	
		return modelMapper.map(user,UserResDTO.class);
	}
	
}
