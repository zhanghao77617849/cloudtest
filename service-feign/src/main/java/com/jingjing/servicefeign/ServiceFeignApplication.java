package com.jingjing.servicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 消费者 feign
 * @author saloa
 *
 */

@SpringBootApplication
@EnableEurekaClient  //注册服务
@EnableDiscoveryClient   //消费者
@EnableFeignClients  //开启feign
public class ServiceFeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceFeignApplication.class, args);
	}
}