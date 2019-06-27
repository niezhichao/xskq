package cloud.nzc.auth.feign;

import cloud.nzc.model.po.UserPo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(value="user-service")
@Service
public interface UserClient {
    @PostMapping("/user/getuser")
    public List<UserPo> getUser(UserPo userPo);
}
