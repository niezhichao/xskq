package cloud.nzc.api.claMng;

import cloud.nzc.model.common.HttpResponse;
import cloud.nzc.model.common.Page;
import cloud.nzc.model.po.ClaMng;
import cloud.nzc.model.vo.ClaMngVo;

public interface ClaMngApi {
    HttpResponse getClaMngPageByCondition(ClaMngVo claMngVo);
}
