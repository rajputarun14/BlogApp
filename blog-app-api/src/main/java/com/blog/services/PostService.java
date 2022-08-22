package com.blog.services;

import java.util.List;

import com.blog.entities.Post;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto,Integer categoryId, Integer userId);
	
	//update
	PostDto updatePost(PostDto postDto , Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//getAllPost
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy,String sortDir);
	
	//getSinglePost
	PostDto getPostById(Integer postId);
	
	//getAllpostByCategoryId
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//getAllPostByUser
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts
	List<PostDto> searchPosts(String keyword);
	
}
