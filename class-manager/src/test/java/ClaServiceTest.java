import cloud.nzc.cla.ClaManagerApplication;
import cloud.nzc.cla.service.ClaMngService;
import cloud.nzc.model.common.PageInPo;
import cloud.nzc.model.mybatis.page.Page;
import cloud.nzc.model.po.ClaMng;
import cloud.nzc.model.util.StringUtil;
import cloud.nzc.model.vo.ClaMngVo;
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
    private final static Logger log=LoggerFactory.getLogger(ClaServiceTest.class);
    @Autowired
    private ClaMngService claMngService;
    private  ClaMng claMng=new ClaMng();
    private ClaMngVo claMngVo=new ClaMngVo();
    @Test
    public  void testModifyMethod(){
        PageInPo<ClaMng> claMngPage=claMngService.getClaMngPageByCondition(claMngVo);
        log.info(claMngPage.getPageNum()+","+claMngPage.getTotal()+","+claMngPage.getPageSize()+","+claMngPage.getData());
    }
}
