import cloud.nzc.xskq.register.EurekaServerApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.http.EurekaApplications;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/*@RunWith(SpringRunner.class)
@SpringBootTest(classes =EurekaServerApplication.class)*/
public class TestCom {
    @Test
    public  void testNumber(){
        String t="/home/ap/1234.txt";
        String r=t.replace("-","");
        String fileNameSuf=t.substring(t.lastIndexOf(".",t.length()));
        System.out.println(fileNameSuf);
    }
}
