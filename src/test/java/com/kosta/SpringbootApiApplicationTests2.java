package com.kosta;

import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.kosta.posts.model.Post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpringbootApiApplicationTests2 {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() throws Exception {
		// 기본 uri
		String uri = "http://localhost:" + port + "/posts/";
		System.out.println("포트 = " + port);

		Scanner scan = new Scanner(System.in);
		System.out.println("----------------------------------");
		System.out.println("명령어 : getall/getid/insert/update/delete/end");

		while (scan.hasNext()) {
			String input = scan.next();
			if (input.equals("getall")) {
				// getAll
				String responseGetAll = this.restTemplate.getForObject(uri, String.class);
				System.out.println("GET ALL 가져오기 = " + responseGetAll);
				System.out.println("----------------------------------");
				System.out.println("명령어 : getall/getid/insert/update/delete/end");
			} else if (input.equals("getid")) {
				System.out.println("get하기 원하는 id를 적으시오:");
				String scanId = scan.next();

				if (scanId != null) {
					// getById
					String responseGetById = this.restTemplate.getForObject(uri + scanId, String.class);
					System.out.println("GET by Id(" + scanId + ") 가져오기" + responseGetById);
					System.out.println("----------------------------------");
					System.out.println("명령어 : getall/getid/insert/update/delete/end");
				}

			}else if (input.equals("insert")) {
				// INSERT postId는 자동 ++
				Post post = new Post();
				post.setSubject("subject insert");
				post.setContent("content insert");
				String responsePost = this.restTemplate.postForObject(uri, post, String.class);
				System.out.println("INSERT id는 자동= " + responsePost);
				System.out.println("----------------------------------");
				System.out.println("명령어 : getall/getid/insert/update/delete/end");
				
				/*
				 * String jsonStr = "{"+"postId: '6'," + "subject: 'subject insert'," +
				 * "content: 'content insert' " + "}"; JSONObject jsonObj = new
				 * JSONObject(jsonStr);
				 */
			}else if(input.equals("update")) {
				//UPDATE
				System.out.println("UPDATE 원하는 id를 적으시오:");
				String scanId2 = scan.next();
				int id = Integer.parseInt(scanId2);
				if(id!=0) {
					Post post2 = new Post(id,"subject update"+id,"content update"+id);
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_JSON);
					
					HttpEntity<Post> entity = new HttpEntity<Post>(post2, headers);
					ResponseEntity<String> responseUpdate =
					this.restTemplate.exchange(uri+id,HttpMethod.PUT,entity, String.class);
					
					System.out.println("UPDATE id("+id+") = " +responseUpdate);
				}
				
			}else if(input.equals("delete")) {
				System.out.println("DELETE 원하는 id를 적으시오:");
				String scanId3 = scan.next();
				int id = Integer.parseInt(scanId3);
				if(id!=0) {
					
					this.restTemplate.delete(uri+id);
					System.out.println(id+"DELETE 성공");
					System.out.println("----------------------------------");
					System.out.println("명령어 : getall/getid/insert/update/delete/end");
				}
				
			}else if (input.equals("end")) {
				scan.close();
			}

		}

	}

}
