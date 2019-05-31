package org.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class CustomizeContainerConfiguration implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	@Autowired
	private Environment env;

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		// port 8181 is loaded with the help of EnvironmentPostProcessorExample before
		// the context is refreshed
		factory.setPort(Integer.parseInt(env.getProperty("spring.server.port")));
	}

}
