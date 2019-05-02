package org.test;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link SpringBootApplication} is a convenience annotation that adds all of
 * the following: <br>
 * {@link Configuration} tags the class as a source of bean definitions for the
 * application context. <br>
 * {@link EnableAutoConfiguration} tells Spring Boot to start adding beans based
 * on classpath settings, other beans, and various property settings. <br>
 * Normally you would add {@link EnableWebMvc} for a Spring MVC app, but Spring
 * Boot adds it automatically when it sees spring-webmvc on the classpath. This
 * flags the application as a web application and activates key behaviors such
 * as setting up a DispatcherServlet. <br>
 * {@link ComponentScan} tells Spring to look for other components,
 * configurations, and services in the org.test package, allowing it to find the
 * controllers.
 */
@SpringBootApplication
public class AppInit {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(AppInit.class);
		//app.setDefaultProperties(Collections.singletonMap("server.port", port));
		app.run(args);
	}

	/**
	 * this runs on start up. It retrieves all the beans that were created either by
	 * your app or were automatically added thanks to Spring Boot. It sorts them and
	 * prints them out
	 * 
	 * @param context
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = context.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

	/*@Value("${spring.server.port}")
	public void setServerPort(String serverPort) {
		System.out.println("************************************************************");
		System.out.println(serverPort);
		AppInit.port = serverPort;
	}*/
}
