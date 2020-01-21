package com.example.arabasozlugu.ArabaSozlugu.service;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.PostReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.PostResDTO;

public interface PostService {

	PostResDTO addPost(PostReqDTO post);

}
