package cloud.nzc.attendance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AttendanceApplication {
    public  static  void  main(String[] args){
        SpringApplication.run(AttendanceApplication.class,args);
    }
}
