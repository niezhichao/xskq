package cloud.nzc.user.controller;

import cloud.nzc.model.po.AppUserPermission;
import cloud.nzc.model.po.UserPo;
import cloud.nzc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/getuser")
    public List<UserPo> getUser(@RequestBody UserPo userPo){
        return userService.getListByParam(userPo);
    }
    @GetMapping("/getUserPermisson")
    public AppUserPermission getUserPermission(@RequestParam("username")String username){
        return userService.getUserWithPermissionByUserName(username);
    }
}
