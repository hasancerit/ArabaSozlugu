package com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PostReqDTO {

	@NotNull
	private String userId;
	
	@Valid
	@NotNull
	private CarReqDTO car;
	
	@NotNull
	private String aciklama;
	
	@NotNull
	private String fiyat;
}
