package cloud.nzc.cla.controller;

import cloud.nzc.api.claMng.ClaMngApi;
import cloud.nzc.cla.service.ClaMngService;
import cloud.nzc.model.common.HttpResponse;
import cloud.nzc.model.common.PageInPo;
import cloud.nzc.model.po.ClaMng;
import cloud.nzc.model.vo.ClaMngVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/claMng")
public class ClaController implements ClaMngApi {
    @Autowired
    ClaMngService claMngService;
    @GetMapping("/getClaMngList")
    @Override
    public HttpResponse getClaMngPageByCondition(ClaMngVo claMngVo) {
        PageInPo<ClaMng> claMngPage=claMngService.getClaMngPageByCondition(claMngVo);
        return HttpResponse.toPage(claMngPage);
    }
}
