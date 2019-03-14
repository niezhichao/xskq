package cloud.nzc.gateway;

import cloud.nzc.gateway.filter.PreFileterTest;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableOAuth2Sso
public class GatewayApplication {
    public  static  void main(String[] args){
        SpringApplication.run(GatewayApplication.class,args);
    }
    @Bean
    public PreFileterTest preFileterTest()throws ZuulException {
        return  new PreFileterTest();
    }
}
