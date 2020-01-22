package com.example.arabasozlugu.ArabaSozlugu.service;

import java.util.List;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.LoginUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.SingupUserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.UserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.user.UserResDTO;

public interface UserService {

	UserResDTO signup(SingupUserReqDTO user);

	UserResDTO login(LoginUserReqDTO user);

	UserResDTO getUser(String id);

	List<UserResDTO> getAllUsers();

	UserResDTO deleteUser(String id);

	UserResDTO updateUser(UserReqDTO user, String id);

	UserResDTO findUserByPost(String postId);

}
