package cloud.nzc.gateway.service;

import cloud.nzc.common.CookieUtil;
import cloud.nzc.model.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class AuthTokenService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 从cookie取出身份令牌
     * @param request
     * @return
     */
    public String getTokenFromCookie(HttpServletRequest request){
        Map<String,String> cookieMap=new HashMap<>();
        cookieMap=CookieUtil.readCookie(request,"uid");
        String access_token=cookieMap.get("uid");
        if(StringUtils.isEmpty(access_token)){
            return null;
        }
        return access_token;
    }

    /**
     * 头信息获取jwt令牌
     * @return
     */
    public  String getJWTFromHeader(HttpServletRequest request){
        String authorization=request.getHeader("Authorization");
        if(StringUtils.isEmpty(authorization)){
            return null;
        }
        //判断authorization是否依Bearer开头
        if(!authorization.startsWith("Bearer ")){
            return null;
        }
        //取到jwt令牌
        String jwt = authorization.substring(7);
        return jwt;
    }

    /**
     * 查询令牌的有效期
     * @param access_token
     * @return
     */
    public long getExpire(String access_token){
        //key
        String key = "user_token:"+access_token;
        Long expire = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
        return expire;
    }
}
