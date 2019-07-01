package cloud.nzc.auth.service;

import cloud.nzc.common.AppSerivceName;
import cloud.nzc.model.auth.AuthToken;
import cloud.nzc.model.exception.GlobalException;
import cloud.nzc.model.common.ResultCode;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class AuthService {
    @Value("${auth.tokenValiditySeconds}")
    int tokenValiditySeconds;
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    private final static Logger log=LoggerFactory.getLogger(AuthService.class);
    @Autowired
    RestTemplate restTemplate;
    public AuthToken loging(String username,String password,String clientId,String clientSecret) {
            AuthToken authToken=applyToken(username,password,clientId,clientSecret);
                //用户身份令牌
            String access_token=authToken.getAccess_token();
            log.info("********save access_token start:"+access_token+"***********");
            //将JMT令牌存储到redis
            String jsonStr= JSON.toJSONString(authToken);
        //将令牌存储到redis
        boolean result = this.saveTokenToReids(access_token, jsonStr, tokenValiditySeconds);
            return  authToken;
    }

   private AuthToken applyToken(String username,String password,String clientId,String clientSecret){

       ServiceInstance instance=loadBalancerClient.choose(AppSerivceName.AUTHSERVICE.getAppServiceName());
       URI uri=instance.getUri();
       String authUrl=uri+"/auth/oauth/token";
       log.info("authURL in method applyToken is----"+authUrl);
       LinkedMultiValueMap<String,String>  header=new LinkedMultiValueMap<>();
       String httpbasic=getHttpbasic(clientId,clientSecret);// 客户端id 和密钥进行base64编码再加如请求header中
       header.add("Authorization",httpbasic);
       LinkedMultiValueMap<String,String>  body=new LinkedMultiValueMap<>();
       body.add("grant_type","password");
       body.add("username",username);
       body.add("password",password);
       HttpEntity<MultiValueMap<String,String>> httpEntity=new HttpEntity<>(body,header);
       restTemplate.setErrorHandler(new DefaultResponseErrorHandler(){
           @Override
           public void handleError(ClientHttpResponse response) throws IOException {
               if(response.getRawStatusCode()!=400 && response.getRawStatusCode()!=401){
                   super.handleError(response);
               }
           }
       });
       ResponseEntity<Map> exchange=restTemplate.exchange(authUrl,HttpMethod.POST,httpEntity,Map.class);
       Map bodyMap=exchange.getBody();
       if (bodyMap == null ||
               bodyMap.get("access_token") == null ||
               bodyMap.get("refresh_token") == null ||
               bodyMap.get("jti") == null){
           if(bodyMap !=null && bodyMap.get("error_description") !=null){
               String error_description = (String) bodyMap.get("error_description");
               if(error_description.indexOf("UserDetailsService returned null")>=0){
                   throw new GlobalException(ResultCode.USERNAME_ERROR);
               }else if(error_description.indexOf("坏的凭证")>=0){
                  throw new GlobalException(ResultCode.CREDENTIAL_ERROR);
               }
           }
           return  null;
       }

       AuthToken authToken=new AuthToken();
       authToken.setAccess_token((String) bodyMap.get("jti"));//用户身份令牌
       authToken.setRefresh_token((String) bodyMap.get("refresh_token"));//刷新令牌
       authToken.setJwt_token((String) bodyMap.get("access_token"));//jwt令牌
       return  authToken;
    }

    /**
     *
     * @param access_token 短令牌 jti
     * @param authToken jwt令牌
     * @param ttl 超时时间
     * @return
     */
    private boolean saveTokenToReids(String access_token,String authToken,int ttl){
        String key="user_token:"+access_token;
        stringRedisTemplate.boundValueOps(key).set(authToken,ttl, TimeUnit.SECONDS);
        Long expire=stringRedisTemplate.getExpire(key,TimeUnit.SECONDS);
        return expire>0;
    }

    /**
     * 从redis获取jwt令牌
     * @param token  短令牌 jti
     * @return
     */
    public AuthToken getTokenFromReids(String token){
        String key = "user_token:" + token;
        String value=stringRedisTemplate.opsForValue().get(key);
        AuthToken authToken =JSON.parseObject(value,AuthToken.class);
        return  authToken;
    }


    private String  getHttpbasic(String clientId,String clientSecret){
        String  res=clientId+":"+clientSecret;
        byte[] encode=Base64Utils.encode(res.getBytes());
        return  "Basic "+new String(encode);
    }
}
