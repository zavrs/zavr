package com.zavr.zavrgatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableZuulProxy
public class ZavrGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZavrGatewayServiceApplication.class, args);
	}
}
