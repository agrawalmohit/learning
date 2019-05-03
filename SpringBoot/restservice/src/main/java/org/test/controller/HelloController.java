package org.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The class is flagged as a {@link RestController}, meaning it’s ready for use
 * by Spring MVC to handle web requests. {@link RequestMapping} maps / to the
 * index() method. When invoked from a browser or using curl on the command
 * line, the method returns pure text. That’s because {@link RestController}
 * combines {@link Controller} and {@link ResponseBody}, two annotations that
 * results in web requests returning data rather than a view.<br/>
 * The {@link RestController} annotation tells Spring to render the resulting
 * data directly back to the caller
 * 
 * @author Mohit.Agarwal
 *
 */
@RestController
public class HelloController {

	@Autowired
	private Environment env;

	/**
	 * Index.<br/>
	 * The {@link RequestMapping} annotation provides “routing” information. It
	 * tells Spring that any HTTP request with the <b>/</b> path should be mapped to
	 * the {@code index} method
	 * 
	 * @return the string
	 */
	@RequestMapping("/")
	public String index() {
		System.out.println(env.getProperty("custom.config.database.user"));
		return "Greetings from Spring Boot!";
	}

}
