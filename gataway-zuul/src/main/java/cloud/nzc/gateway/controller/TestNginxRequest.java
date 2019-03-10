package cloud.nzc.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestNginxRequest {
    @RequestMapping("test")
    public String test1(String password, String username){
        String res=password+" and "+username;
        return res;
    }
}
