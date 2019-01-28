package com.jingjing.servicemiya;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
@RestController
public class ServiceMiyaApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(ServiceMiyaApplication.class);
	
	@RequestMapping("/hi")
	public String home() {
		LOGGER.info(" hi is being called");
		return "hi i'm miya!";
	}
	
	@RequestMapping("/miya")
	public String info() {
		System.out.println("1111111");
		LOGGER.info("miya is being called");
		return restTemplate.getForObject("http://localhost:8988/info", String.class);
	}

	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate geRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public Sampler defailtSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceMiyaApplication.class, args);
	}
}
