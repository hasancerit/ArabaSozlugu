package com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.car;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CarReqDTO {
	@NotNull
	private String modelAdi;
	private String yakıt;
	private String vites;
	private String silindirHacmi;
	private String beygir;
	@NotNull
	private String yas;
}
