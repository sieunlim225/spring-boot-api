package com.kosta.posts.dao;

import java.util.List;

import com.kosta.posts.model.Post;

public interface PostDao {

	public Post addNewPost(Post post);
	public List<Post> findAllPost();
	public Post selectOnePost(int postId);
	public Post updateOnePost(Post post);
	public void deleteOnePost(int postId);
}
