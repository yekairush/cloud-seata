package com.spirit.cloud.seata.business;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @author User
 *
 */
@EnableFeignClients
@SpringBootApplication
public class CloudSeataBusinessApplication {

  public static void main(String[] args) {
    SpringApplication.run(CloudSeataBusinessApplication.class, args);
  }

}
