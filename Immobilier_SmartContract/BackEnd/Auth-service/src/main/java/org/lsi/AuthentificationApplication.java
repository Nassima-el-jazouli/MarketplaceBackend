package org.lsi;

//import org.lsi.entities.UserName;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@ComponentScan(basePackageClasses = UserName.class)
public class AuthentificationApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AuthentificationApplication.class, args);
	}

}
