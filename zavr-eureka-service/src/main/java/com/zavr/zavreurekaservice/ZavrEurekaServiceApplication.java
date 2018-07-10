package com.zavr.zavreurekaservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaServer
public class ZavrEurekaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZavrEurekaServiceApplication.class, args);
	}
}
