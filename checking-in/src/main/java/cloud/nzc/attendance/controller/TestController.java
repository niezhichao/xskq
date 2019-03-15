package cloud.nzc.attendance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@RequestMapping("/attendance")
public class TestController {
    @RequestMapping("/test.do")
    public  String test(HttpServletRequest request){
        System.out.println("- - - - - - -head - - - - - - - -");
        Enumeration headerNames=request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String key=(String) headerNames.nextElement();
            System.out.println(key+":"+request.getHeader(key));
        }
        System.out.println("- - - - - - -head - - - - - - - -");
        return "helloooooooooooooooooooooooooo!!!";
    }
}
