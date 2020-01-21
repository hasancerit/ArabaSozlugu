package com.example.arabasozlugu.ArabaSozlugu.service;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.LoginUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.SingupUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.UserResDTO;

public interface UserService {



	UserResDTO signup(SingupUserReqDTO user);

	UserResDTO login(LoginUserReqDTO user);

}
