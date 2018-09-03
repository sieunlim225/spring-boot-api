package com.kosta;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.kosta.posts.api.PostApiController;
import com.kosta.posts.dao.PostDao;
import com.kosta.posts.service.PostService;

@RunWith(SpringRunner.class)
@WebMvcTest(PostApiController.class)
public class SpringbootApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private PostService service;

/*	@Autowired
	private TestRestTemplate testRestTemplate;*/
	@Value("http://localhost:8080")
	String baseUrl;
	
	@Before
	 public void setUp() {
		
	}
	@Test
	public void contextLoads() throws Exception{
		

			this.mockMvc.perform(get("/posts")).andDo(print());
		
		
		//assertThat(controller).isNotNull();
		
		//assertThat(this.testRestTemplate.getForObject(baseUrl+"/posts", String.class));
		/*// RestTemplate 객체를 얻는다.
		RestTemplate restTemplate = new RestTemplate();

		//지정 URL을 GET 타입으로 호출한다.
		ResponseEntity<String> response = restTemplate.getForEntity(baseUrl+"/posts", String.class);
		
		// 정상적으로 처리가 되었는지 확인한다.
		assertTrue(response.getStatusCode().is2xxSuccessful());*/
		
		/*// 응답의 본문(body)를 얻으려면 getBody() 메소드를 호출한다.
				String html = response.getBody();
				System.out.println(html);
				
				// 아이템을 삽입한다.
				response = restTemplate.postForEntity("http://local.net/crud", System.currentTimeMillis(), String.class);
				assertTrue( response.getStatusCode().is2xxSuccessful() );
				response = restTemplate.postForEntity("http://local.net/crud", System.currentTimeMillis(), String.class);
				assertTrue( response.getStatusCode().is2xxSuccessful() );

				// {}을 이용해 추가 파라미터를 지정할 수 있다.
				response = restTemplate.getForEntity("http://local.net/crud/{index}", String.class, 0);
				assertTrue( response.getStatusCode().is2xxSuccessful() );

				// {}을 이용해 추가 파라미터 입력시 map도 사용할 수 있다.
				Map<String, Object> param = new HashMap<String, Object>();
				param.put("index", 0);
				response = restTemplate.getForEntity("http://local.net/crud/{index}", String.class, param);
				assertTrue( response.getStatusCode().is2xxSuccessful() );

				// 아이템을 갱신한다.
				restTemplate.put("http://local.net/crud/{index}", "update:"+System.currentTimeMillis(), 0);

				// 아이템을 삭제한다.
				restTemplate.delete("http://local.net/crud/{index}", 1);*/
		
	}

}
