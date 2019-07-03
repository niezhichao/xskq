import cloud.nzc.model.po.AppPermission;
import cloud.nzc.model.po.AppUserPermission;
import cloud.nzc.model.po.UserPo;
import cloud.nzc.user.UserServiceApplication;
import cloud.nzc.user.dao.AppPermissinDao;
import cloud.nzc.user.dao.UserMapper;
import cloud.nzc.user.service.UserService;
import jdk.nashorn.internal.scripts.JO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest(classes = {UserServiceApplication.class})
@RunWith(SpringRunner.class)
public class TestDao {
    private final  static Logger log=LoggerFactory.getLogger(TestDao.class);
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Autowired
    private AppPermissinDao appPermissinDao;
    @Test
    public void testUserDao(){
        AppUserPermission appUserPermission=userService.getUserWithPermissionByUserName("nzc");
        log.info(appUserPermission.toString());
    }

    @Test
    public void testUserDao2(){
        List<AppPermission> appPermissions=appPermissinDao.selectListByUserName("nzc");
        log.info(appPermissions.toString());
    }
}
