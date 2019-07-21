package cloud.nzc.auth.feign;

import cloud.nzc.common.AppSerivceName;
import cloud.nzc.model.common.CommonCodeUtil;
import cloud.nzc.model.po.AppUserPermission;
import cloud.nzc.model.po.UserPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value=CommonCodeUtil.USER_SERVICE)
@Service
public interface UserClient {
    @PostMapping("/user/getuser")
    public List<UserPo> getUser(@RequestBody UserPo userPo);
    @GetMapping("/user/getUserPermisson")
    public AppUserPermission getUserPermission(@RequestParam("username") String username);
}
