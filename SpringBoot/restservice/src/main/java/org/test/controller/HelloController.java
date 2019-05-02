package org.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The class is flagged as a {@link RestController}, meaning it’s ready for use by
 * Spring MVC to handle web requests. {@link RequestMapping} maps / to the index()
 * method. When invoked from a browser or using curl on the command line, the
 * method returns pure text. That’s because {@link RestController} combines {@link Controller}
 * and {@link ResponseBody}, two annotations that results in web requests returning
 * data rather than a view
 * 
 * @author Mohit.Agarwal
 *
 */
@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
