package com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.post;

import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.car.CarResDTO;
import com.example.arabasozlugu.ArabaSozlugu.model.Car;
import com.example.arabasozlugu.ArabaSozlugu.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class PostResDTO {
	private String id;
	private String aciklama;
	private String fiyat;
	@JsonIgnore
	private User user;
	
	private CarResDTO car;
}