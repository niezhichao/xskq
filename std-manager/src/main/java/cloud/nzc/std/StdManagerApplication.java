package cloud.nzc.std;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StdManagerApplication {
    public  static  void main(String[] args){
        SpringApplication.run(StdManagerApplication.class,args);
    }
}
