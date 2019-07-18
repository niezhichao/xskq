package cloud.nzc.cla;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "cloud.nzc.cla.dao")
@ComponentScan(basePackages = {"cloud.nzc.cla"})
public class ClaManagerApplication {
    public  static  void main(String[] args){
        SpringApplication.run(ClaManagerApplication.class,args);
    }
}
