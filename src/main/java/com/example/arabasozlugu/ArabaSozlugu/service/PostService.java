package com.example.arabasozlugu.ArabaSozlugu.service;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.post.PostReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.post.PostResDTO;

public interface PostService {

	PostResDTO addPost(PostReqDTO post);

}
