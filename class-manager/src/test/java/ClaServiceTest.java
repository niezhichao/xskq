import cloud.nzc.cla.ClaManagerApplication;
import cloud.nzc.cla.service.ClaMngService;
import cloud.nzc.model.po.ClaMng;
import cloud.nzc.model.util.StringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClaManagerApplication.class)
public class ClaServiceTest {
    private Logger log=LoggerFactory.getLogger(ClaServiceTest.class);
    @Autowired
    private ClaMngService claMngService;
    private  ClaMng claMng=new ClaMng();
    @Test
    public void insertTest()throws Exception{
        claMng.setiD(StringUtil.getUUID());
        claMng.setcName("火箭炮班");
        claMng.setcRemark("120火箭炮");
        int res=claMngService.insert(claMng);
        log.info("clamng 成功插入： "+res);
    }
    @Test
    public void deleteTest()throws Exception{
        int res = claMngService.deleteClaMngById("1");
        claMngService.deleteClaMngByCondiction(claMng);
        List<String> deleteIds= new ArrayList<>();
        deleteIds.add("2");
        deleteIds.add("3");
        claMngService.deleteClaMngByIds(deleteIds);

    }
    @Test
    public void updateTest()throws Exception{
        claMng.setiD("584654fe15774dd4beadad7c9f97a52a");
        claMng.setcName("侦察班");
        claMng.setcRemark(null);
        int res=claMngService.updateNotEmptyByPrimarykey(claMng);
        log.info("clamng updateNotEmptyByPrimarykey 方法 成功更新： "+res);

    }


}
