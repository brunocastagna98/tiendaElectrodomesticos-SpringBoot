package com.brunocastagna.eureka_server_electro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerElectroApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerElectroApplication.class, args);
	}

}
