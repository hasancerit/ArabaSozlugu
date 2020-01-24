package com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserReqDTO {
	private String name;
	private String user;
	private String  pass;
}
