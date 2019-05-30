package org.test;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class CustomizeContainerConfiguration implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

	@Override
	public void customize(ConfigurableWebServerFactory factory) {
		// port 8181 is loaded with the help of EnvironmentPostProcessorExample before
		// the context is refreshed
		factory.setPort(8989);
	}

}
