package com.zavr.usercenterservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableAutoConfiguration
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@MapperScan("com.zavr.usercenterservice.mapper")
public class ZavrUserCenterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZavrUserCenterServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced //增加riboon的负载均衡
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
