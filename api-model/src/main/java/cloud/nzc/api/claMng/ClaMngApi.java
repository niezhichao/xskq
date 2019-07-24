package cloud.nzc.api.claMng;

import cloud.nzc.model.common.HttpResponse;
import cloud.nzc.model.po.ClaMng;
import cloud.nzc.model.vo.ClaMngVo;
import org.springframework.web.multipart.MultipartFile;

public interface ClaMngApi {
    HttpResponse getClaMngPageByCondition(ClaMngVo claMngVo);
    HttpResponse createClaMng(ClaMngVo claMngVo) throws Exception;
    HttpResponse uploadFile(MultipartFile file);
}
