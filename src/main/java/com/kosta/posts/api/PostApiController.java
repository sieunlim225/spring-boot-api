package com.kosta.posts.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.posts.model.Post;
import com.kosta.posts.service.PostService;
import com.kosta.response.ApiDataResponse;
import com.kosta.response.ApiResponse;

@RestController
public class PostApiController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/posts")
	@ResponseBody
	public ApiResponse regist(@RequestBody Post post) {
		/*System.out.println(post.getSubject());
		System.out.println(post.getContent());*/
		Post registeredPost = postService.addNewPost(post);
		//return postService.addNewPost(post);
		return new ApiDataResponse<Post>(registeredPost);
	}
	
	@GetMapping("/posts")
	public ApiDataResponse<List<Post>> getAllPosts(){
		
		/*Post post = new  Post();
		post.setSubject(subject);
		post.setContent(content);
		return post;*/
		
		//return postService.findAllPost();
		List<Post> allPostsList = postService.findAllPost();
		return new ApiDataResponse<List<Post>>(allPostsList);
	 }
	
	@GetMapping("/posts/{postId}")
	public ApiDataResponse<Post> getAllPosts2(@PathVariable int postId){
		
		/*Post post = new  Post();
		post.setPostId(postId);
		
		return post;*/
	 
		//return postService.selectOnePost(postId);
		return new ApiDataResponse<Post>(postService.selectOnePost(postId));
	}
	
	@PutMapping("/posts/{postId}")
	public ApiDataResponse<Post> updateOnePost(@PathVariable int postId,
			@RequestBody Post post
	) {
		
		//return postService.updateOnePost(postId, post);
		return new ApiDataResponse<Post>(postService.updateOnePost(postId, post));
	}
	
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deleteOnePost(@PathVariable int postId) {
		postService.deleteOnePost(postId);
		return new ApiResponse();
	}
}
