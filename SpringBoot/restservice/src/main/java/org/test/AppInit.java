package org.test;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

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
	

	/**
	 * The main method. This is just a standard method that follows the Java
	 * convention for an application entry point. Our main method delegates to
	 * Spring Boot’s SpringApplication class by calling run. SpringApplication
	 * bootstraps our application, starting Spring, which, in turn, starts the
	 * auto-configured Tomcat web server. We need to pass {@link AppInit}.class as
	 * an argument to the run method to tell SpringApplication which is the primary
	 * Spring component. The args array is also passed through to expose any
	 * command-line arguments.<br/>
	 * <br/>
	 * Use {@code 'mvn spring-boot:run'} from the root project directory to start
	 * application
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(AppInit.class, args);
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
}
