package com.example.arabasozlugu.ArabaSozlugu.exceptions;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.LoginUserReqDTO;

import lombok.Data;

@Data
public class UserNotFoundException extends RuntimeException{
	private LoginUserReqDTO user;
	public UserNotFoundException(String msg,LoginUserReqDTO user) {
		super(msg);
		this.user = user;
	}
}
