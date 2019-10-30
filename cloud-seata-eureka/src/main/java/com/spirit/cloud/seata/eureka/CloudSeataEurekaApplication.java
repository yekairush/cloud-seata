package com.spirit.cloud.seata.eureka;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author User
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class CloudSeataEurekaApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudSeataEurekaApplication.class, args);
  }

}
