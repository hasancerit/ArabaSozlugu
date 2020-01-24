package com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.user;

import java.util.HashSet;
import java.util.Set;

import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.car.CarResDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.post.PostResDTO;
import com.example.arabasozlugu.ArabaSozlugu.model.Car;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class UserResDTO {
	private String id;
	private String name;
	private String user;
	private String  pass;
	private Set<CarResDTO> cars = new HashSet<CarResDTO>();
	private Set<PostResDTO> posts = new HashSet<PostResDTO>();
	
	public void setPostsUserId() {
		for(PostResDTO p : posts) {
			p.setUserId();
		}
	}
	
	private String token;
}
