import cloud.nzc.model.po.UserPo;
import cloud.nzc.user.UserServiceApplication;
import cloud.nzc.user.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = {UserServiceApplication.class})
@RunWith(SpringRunner.class)
public class TestDao {
    @Autowired
    UserMapper userMapper;
    @Test
    public void testUserDao(){
        UserPo user=new UserPo();
        user.setuName("nie");
       List<UserPo> userPos =userMapper.selectByCondition(user);
       System.out.println(userPos);
    }

}
