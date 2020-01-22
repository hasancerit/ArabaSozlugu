package com.example.arabasozlugu.ArabaSozlugu.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.arabasozlugu.ArabaSozlugu.model.Post;
import com.example.arabasozlugu.ArabaSozlugu.model.User;

@Repository
public interface UserRepo  extends JpaRepository<User, String>{
	public User findByUser(String user);

}
