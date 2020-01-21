package com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.example.arabasozlugu.ArabaSozlugu.model.Post;
import com.example.arabasozlugu.ArabaSozlugu.model.User;

import lombok.Data;

@Data
public class CarResDTO {
	private String id;
	private String modelAdi;
	private String yakıt;
	private String vites;
	private String silindirHacmi;
	private String beygir;
	private String yas;
	private User user;
	private Post post;	

}
