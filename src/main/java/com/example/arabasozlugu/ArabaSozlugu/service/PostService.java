package com.example.arabasozlugu.ArabaSozlugu.service;

import java.util.List;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.post.PostReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.post.PostResDTO;

public interface PostService {

	PostResDTO addPost(PostReqDTO post);

	PostResDTO getPost(String id);

	List<PostResDTO> getAll();

	PostResDTO delete(String id);

}
