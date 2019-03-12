package cloud.nzc.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zuul")
public class TestController {
    @RequestMapping("/test.do")
    public  String test(String password,String username){
        String res=password+"   "+username;
        return res;
    }
}
