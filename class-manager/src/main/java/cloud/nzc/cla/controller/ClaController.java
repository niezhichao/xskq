package cloud.nzc.cla.controller;

import cloud.nzc.api.claMng.ClaMngApi;
import cloud.nzc.cla.service.ClaMngService;
import cloud.nzc.common.StringUtil;
import cloud.nzc.model.common.HttpResponse;
import cloud.nzc.model.common.PageInPo;
import cloud.nzc.model.common.ResultCode;
import cloud.nzc.model.po.ClaMng;
import cloud.nzc.model.vo.ClaMngVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/claMng")
public class ClaController implements ClaMngApi {
    private  static final Logger log=LoggerFactory.getLogger(ClaController.class);
    @Autowired
    ClaMngService claMngService;
    @Value("${save.filePath}")
    String filePath;
    @GetMapping("/getClaMngList")
    @Override
    public HttpResponse getClaMngPageByCondition(ClaMngVo claMngVo) {
        PageInPo<ClaMng> claMngPage=claMngService.getClaMngPageByCondition(claMngVo);
        return HttpResponse.toPage(claMngPage);
    }

    @Override
    @PostMapping("/upload")
    public HttpResponse uploadFile(MultipartFile file) {
        return null;
    }

    @GetMapping("/addClaMng")
    @Override
    public HttpResponse createClaMng(ClaMngVo claMngVo)throws Exception {
        HttpResponse res=new HttpResponse();
        if ("".equals(claMngVo.getcName()) || null==claMngVo.getcName()){
            res.setCode(ResultCode.CLAINSERTFAIL.getCode());
            res.setMsg(ResultCode.CLAINSERTFAIL.getMsg());
            return res;
        }
        ClaMng claMng=new ClaMng(claMngVo.getcName(),claMngVo.getcRemark());
        claMng.setiD(StringUtil.getUUID());
        claMngService.insert(claMng);
        res.setCode(ResultCode.SUCCESS.getCode());
        res.setMsg(ResultCode.SUCCESS.getMsg());
        return res;
    }
}
