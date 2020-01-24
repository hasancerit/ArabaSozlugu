package com.example.arabasozlugu.ArabaSozlugu.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.LoginUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.SingupUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.UserReqDTO;import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.post.PostResDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.user.JWTUserResDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.user.UserResDTO;
import com.example.arabasozlugu.ArabaSozlugu.exceptions.UserNotFoundException;
import com.example.arabasozlugu.ArabaSozlugu.jwt.JWTUtil;
import com.example.arabasozlugu.ArabaSozlugu.model.Post;
import com.example.arabasozlugu.ArabaSozlugu.model.User;
import com.example.arabasozlugu.ArabaSozlugu.repo.PostRepo;
import com.example.arabasozlugu.ArabaSozlugu.repo.UserRepo;
import com.example.arabasozlugu.ArabaSozlugu.service.UserService;
import com.example.arabasozlugu.ArabaSozlugu.utils.SecurityConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserServiceImp implements UserService{
	UserRepo userRepo;
	PostRepo postRepo;
	ModelMapper modelMapper;
	JavaMailSender mailSender;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	
	@Autowired
	public UserServiceImp(UserRepo userRepo,PostRepo postRepo,ModelMapper modelMapper,
			BCryptPasswordEncoder bCryptPasswordEncoder,JavaMailSender mailSender) {
		this.userRepo = userRepo;
		this.postRepo = postRepo;
		this.modelMapper = modelMapper;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.mailSender = mailSender;
	}
	
	@Override
	public UserResDTO signup(SingupUserReqDTO user){
       // user.setPass(bCryptPasswordEncoder.encode(user.getPass()));
		User userEnt = userRepo.save(modelMapper.map(user,User.class));
		try {
			userEnt = userRepo.save(userEnt);
		}catch (Exception e) {
			return null;
		}
		UserResDTO userResp = modelMapper.map(userEnt,UserResDTO.class); 
		userResp.setPostsUserId();
		sendMail("hasan__cerit@hotmail.com", "Subject","Text");
		return userResp;
	}
	
	public void sendMail(String person,String subj,String test){
        System.out.println("Sending Email...");

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(person);
        msg.setSubject(subj);
        msg.setText(test);

        mailSender.send(msg);	
        System.out.println("Done");

	}
	
	@Override
	public JWTUserResDTO login(LoginUserReqDTO user) {
		User userEnt = null;
		try {
			userEnt = userRepo.findByUser(user.getUser());
		}catch (Exception e) {
			System.out.println("TEST");
		}
		if(userEnt == null) {
			throw new UserNotFoundException("Gecersiz Username",user);
		}
		if((userEnt.getPass().equals(user.getPass()))) {			
			JWTUserResDTO userResp = modelMapper.map(userEnt,JWTUserResDTO.class); 
			
			String token = JWTUtil.generateToken(userResp);
			return userResp;
		}
		//throw yanlis sifre
		return null;
	}
	
	@Override
	public UserResDTO getUser(String id) {
		User user = userRepo.findById(id).get();
		if(user == null) {
			//Kullanıcı bulunamadı
		}
	
		UserResDTO userResp = modelMapper.map(user,UserResDTO.class); 
		userResp.setPostsUserId();
		return userResp;
	}
	
	
	@Override
	public List<UserResDTO> getAllUsers() {
		List<User> users = userRepo.findAll();
		List<UserResDTO> usersDTO = new ArrayList<UserResDTO>();
		for(User u : users) {
			UserResDTO urd = modelMapper.map(u, UserResDTO.class);
			urd.setPostsUserId();
			usersDTO.add(urd);
		}
		
		return usersDTO;
	}
	
	@Override
	public UserResDTO deleteUser(String id) {
		User user = userRepo.findById(id).get();
		if(user == null) {
			
		}
		userRepo.delete(user);;
		UserResDTO userResp = modelMapper.map(user,UserResDTO.class); 
		userResp.setPostsUserId();
		return userResp;
	}
	
	@Override
	public UserResDTO updateUser(UserReqDTO user,String id) {
		User eski = userRepo.getOne(id);
		if(eski == null) {
			
		}
		User yeni = modelMapper.map(user, User.class);
		yeni.setId(eski.getId());
		yeni.setCars(eski.getCars());
		yeni.setPosts(eski.getPosts());
		userRepo.save(yeni);
		UserResDTO userResp = modelMapper.map(yeni,UserResDTO.class); 
		userResp.setPostsUserId();
		return userResp;	
	}
	
	@Override
	public UserResDTO findUserByPost(String postId) {
		Post post = postRepo.findById(postId).get();
		if(post == null) {
			
		}
		User user = post.getUser();
		UserResDTO userResp = modelMapper.map(user,UserResDTO.class); 
		userResp.setPostsUserId();
		return userResp;	
	}
}
