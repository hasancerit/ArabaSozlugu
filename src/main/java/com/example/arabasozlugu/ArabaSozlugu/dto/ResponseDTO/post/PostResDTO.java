package com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.post;

import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.car.CarResDTO;
import com.example.arabasozlugu.ArabaSozlugu.model.Car;
import com.example.arabasozlugu.ArabaSozlugu.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PostResDTO {
	@JsonProperty("test")
	private String id;
	private String aciklama;
	private String fiyat;
	@JsonIgnore
	private User user;
	private String userId;
	private CarResDTO car;
	
	public void setUserId() {	
		userId = user.getId();
	}
}
