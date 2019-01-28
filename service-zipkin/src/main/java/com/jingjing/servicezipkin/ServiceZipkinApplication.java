package com.jingjing.servicezipkin;

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
public class ServiceZipkinApplication {

	private static final Logger LOGGER=LoggerFactory.getLogger(ServiceZipkinApplication.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate geRestTemplate() {
		return new RestTemplate();
	}
	
	
	//这个方法通过RestTemplate调用了http://localhost:8989/miya服务，就此产生了对miya的依赖。
	@RequestMapping("/hi")
	public String callHome() {
		LOGGER.info("calling trace service-miya");
		return restTemplate.getForObject("http://localhost:8989/miya", String.class);
	}
	
	@RequestMapping("/info")
	public String info() {
		System.out.println("22222");
		LOGGER.info("call trace service-hi");
		return "i'm service-hi";
	}
	
	//Brave是一个用于捕捉和报告分布式操作的延迟信息给Zipkin的工具库。 
    //Sampler.ALWAYS_SAMPLE返回一个sampler，设置需要采样
	//该方法返回一个Sampler对象，可以看下源码，意思是这个类需要进行zipkin的依赖采样。当没有这个方法时，zipkin不进行依赖监控。
	@Bean
	public Sampler defailtSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceZipkinApplication.class, args);
	}
}
