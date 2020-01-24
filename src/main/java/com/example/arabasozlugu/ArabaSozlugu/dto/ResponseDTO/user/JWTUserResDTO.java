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
public class JWTUserResDTO {
	private String id;
	private String name;
	private String user;
	private String  pass;
	private String token;
}
