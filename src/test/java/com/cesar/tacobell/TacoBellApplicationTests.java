package com.cesar.tacobell;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// @SpringBootTest igual sabremos algo más adelante...
@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
class TacoBellApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testHomePage() throws Exception {
		mockMvc.perform(get("/"))

				.andExpect(status().isOk()) // 200 Ok
				.andExpect(view().name("home")) // logical name "home"
				.andExpect(content().string( containsString("Welcome to.."))); // RENDERED VIEW contain...
	}

}
