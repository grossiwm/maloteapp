package com.gabrielrossilopes.appmalote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AppMaloteApplication {

	private static Logger LOGGER = LoggerFactory
			.getLogger(AppMaloteApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppMaloteApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate()
	{
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		return new RestTemplate(requestFactory);
	}

}
