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
		factory.setPort(Integer.parseInt(env.getProperty("spring.server.port")));

	}

}
