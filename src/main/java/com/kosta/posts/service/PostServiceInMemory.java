package com.kosta.posts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.kosta.posts.dao.PostDao;
import com.kosta.posts.model.Post;

@Service
public class PostServiceInMemory implements PostService {

	@Autowired
	//Dao의 Impl(구현체)가 2개이기 때문에 오류가난다. 특정 impl 지정으로 Qualifier 사용
	@Qualifier("com.kosta.posts.dao.PostDaoImplH2")
	private PostDao postDao;
	
	@Override
	public Post addNewPost(Post post) {
		return postDao.addNewPost(post);
	}

	@Override
	public List<Post> findAllPost() {
		return postDao.findAllPost();
	}

	@Override
	public Post selectOnePost(int postId) {
		return postDao.selectOnePost(postId);
	}

	@Override
	public Post updateOnePost(int postId, Post post) {
		post.setPostId(postId);
		return postDao.updateOnePost(post);
	}

	@Override
	public void deleteOnePost(int postId) {
		postDao.deleteOnePost(postId);
	}

}
