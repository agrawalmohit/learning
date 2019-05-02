package org.test.unittest.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Note the use of the {@link AutoConfigureMockMvc} together with
 * {@link SpringBootTest} to inject a MockMvc instance. Having used
 * {@link SpringBootTest} we are asking for the whole application context to be
 * created. An alternative would be to ask Spring Boot to create only the web
 * layers of the context using the {@link WebMvcTest}. Spring Boot automatically
 * tries to locate the main application class of your application in either
 * case, but you can override it, or narrow it down, if you want to build
 * something different.
 * 
 * @author Mohit.Agarwal
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

	/**
	 * The <b>MockMvc</b> comes from Spring Test and allows you, via a set of
	 * convenient builder classes, to send HTTP requests into the DispatcherServlet
	 * and make assertions about the result
	 */
	@Autowired
	private MockMvc mvc;

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	}

}
