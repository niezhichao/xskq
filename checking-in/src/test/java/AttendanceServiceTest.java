import cloud.nzc.attendance.AttendanceApplication;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootTest(classes = AttendanceApplication.class)
public class AttendanceServiceTest {
    @Value("${spring.datasource.driver-class-name}")
    private  String rps;
    @Test
    public void connectConfig(){
        System.out.println("fetch from configCenter....:"+rps);
    }
}
