package cloud.nzc.cla;

import cloud.nzc.api.claMng.ClaMngApi;
import cloud.nzc.cla.service.ClaMngService;
import cloud.nzc.model.common.HttpResponse;
import cloud.nzc.model.common.Page;
import cloud.nzc.model.po.ClaMng;
import cloud.nzc.model.vo.ClaMngVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ClaController implements ClaMngApi {
    @GetMapping("")
    @Override
    public Page<ClaMng> getClaMngPageByCondition(ClaMngVo claMngVo) {
        return null;
    }
}
