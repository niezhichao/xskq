import cloud.nzc.model.po.UserPo;
import cloud.nzc.user.UserServiceApplication;
import cloud.nzc.user.dao.UserMapper;
import cloud.nzc.user.service.UserService;
import jdk.nashorn.internal.scripts.JO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.List;

@SpringBootTest(classes = {UserServiceApplication.class})
@RunWith(SpringRunner.class)
public class TestDao {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Test
    public void testUserDao(){
        UserPo xx=new UserPo();
        xx.setuName("nzc");
       List<UserPo> userPos =userService.getListByParam(xx);
       System.out.println(userPos);
    }

}
