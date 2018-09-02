package com.kosta.posts.service;

import java.util.List;

import com.kosta.posts.model.Post;

public interface PostService {

	public Post addNewPost(Post post);
	public List<Post> findAllPost();
	public Post selectOnePost(int postId);
	public Post updateOnePost(int postId, Post post);
	public void deleteOnePost(int postId);
}
