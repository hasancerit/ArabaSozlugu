package com.example.arabasozlugu.ArabaSozlugu.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	private String modelAdi;
	private String yakıt;
	private String vites;
	private String silindirHacmi;
	private String beygir;
	private String yas;

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn
	private User user;
	
	@OneToOne(mappedBy = "car", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Post post;	
}
