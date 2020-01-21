package com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.arabasozlugu.ArabaSozlugu.model.Car;
import com.example.arabasozlugu.ArabaSozlugu.model.Post;

import lombok.Data;

@Data
public class UserResDTO {
	private String id;
	private String name;
	private String user;
	private String  pass;
	private Set<Car> cars = new HashSet<Car>();
	private Set<Post> posts = new HashSet<Post>();
}
