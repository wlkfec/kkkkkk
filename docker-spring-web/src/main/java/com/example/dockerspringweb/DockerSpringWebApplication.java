package com.example.dockerspringweb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/base")
@SpringBootApplication
public class DockerSpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerSpringWebApplication.class, args);
	}

	@GetMapping("/test")
	public String test() {
		log.info(" ===== ===== ===== ===== ===== ===== ");
		return "testtesttest";
	}

}
