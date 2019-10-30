package com.spirit.cloud.seata.storage;



import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

/**
 * 
 * @author User
 *
 */
@MapperScan("com.spirit.cloud.seata.storage.mapper*")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CloudSeataStorageApplication {


  public static void main(String[] args) {
    SpringApplication.run(CloudSeataStorageApplication.class, args);
  }

  @Bean
  @ConfigurationProperties(prefix = "spring.datasource")
  public DruidDataSource druidDataSource() {
    DruidDataSource druidDataSource = new DruidDataSource();
    return druidDataSource;
  }

  @Primary
  @Bean("dataSource")
  public DataSourceProxy dataSource(DruidDataSource druidDataSource) {
    return new DataSourceProxy(druidDataSource);
  }

}
