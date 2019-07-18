package cloud.nzc.cla.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    private  static final Logger log=LoggerFactory.getLogger(ResourceServerConfig.class);
    private  static final String pubKey="pubKey.txt";

    @Bean
    public TokenStore tokenStore(JwtAccessTokenConverter converter){
        return  new JwtTokenStore(converter);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
        try {
            jwtAccessTokenConverter.setVerifierKey(getPubKey());
        }catch (IOException e){
            log.error(e.getMessage());
        }
        return  jwtAccessTokenConverter;
    }

    private  String getPubKey() throws IOException {
        Resource resource=new ClassPathResource(pubKey);
        InputStreamReader inputStreamReader=new InputStreamReader(resource.getInputStream());
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        return bufferedReader.lines().collect(Collectors.joining("\n"));
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated();
    }
}
