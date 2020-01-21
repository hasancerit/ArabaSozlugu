package com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.arabasozlugu.ArabaSozlugu.model.Car;
import com.example.arabasozlugu.ArabaSozlugu.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
public class PostResDTO {
	private String id;
	private String aciklama;
	private String fiyat;
	
	private User user;
	private Car car;
}
