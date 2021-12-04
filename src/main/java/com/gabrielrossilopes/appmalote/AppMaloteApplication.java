package com.gabrielrossilopes.appmalote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
public class AppMaloteApplication {

	private static Logger LOGGER = LoggerFactory
			.getLogger(AppMaloteApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppMaloteApplication.class, args);
	}

}
