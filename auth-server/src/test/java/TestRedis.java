import cloud.nzc.auth.AuthorizationApp;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = AuthorizationApp.class)
@RunWith(SpringRunner.class)

public class TestRedis {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void  testRedis(){
        String key="usertoken:123456";
        Map<String,String> value=new HashMap<>();
        value.put("jwt","888888888");
        value.put("refresh_token","66666666666");
        String jsonString= JSON.toJSONString(value);
        stringRedisTemplate.boundValueOps(key).set(jsonString,30, TimeUnit.SECONDS);
        String str=stringRedisTemplate.opsForValue().get(key);
        System.out.print(str);
    }
}
