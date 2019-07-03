package cloud.nzc.user.service;

import cloud.nzc.model.common.BaseService;
import cloud.nzc.model.common.ResultCode;
import cloud.nzc.model.exception.GlobalException;
import cloud.nzc.model.po.AppPermission;
import cloud.nzc.model.po.AppUserPermission;
import cloud.nzc.model.po.UserPo;
import cloud.nzc.user.dao.AppPermissinDao;
import cloud.nzc.user.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
@Service
public class UserService  implements BaseService<UserPo> {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AppPermissinDao appPermissinDao;
    @Override
    public int insert(UserPo user) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserPo user) {
        return 0;
    }

    @Override
    public int updateNotEmptyByPrimarykey(UserPo user) {
        return 0;
    }

    @Override
    public int deleteById(Object id) {
        return 0;
    }

    @Override
    public int deleteByIds(List ids) {
        return 0;
    }

    @Override
    public UserPo getById(Object id) {
        return null;
    }

    @Override
    public List<UserPo> getAll() {
        return null;
    }

    @Override
    public List<UserPo> getListByParam(UserPo user) {
        return userMapper.selectByCondition(user);
    }

    @Override
    public List<UserPo> getListByIds(List ids) {
        return null;
    }

    @Override
    public UserPo getById(Serializable id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int getCount(UserPo user) {
        return 0;
    }

    public UserPo  getUserByUsername(String username){
        return userMapper.selectByUsername(username);
    }

    public AppUserPermission getUserWithPermissionByUserName(String username){
        UserPo userPo=this.getUserByUsername(username);
        if (userPo==null){
            throw new GlobalException(ResultCode.USERNAME_ERROR);
        }
        UserPo result=new AppUserPermission(userPo);
        List<AppPermission> appPermissions=appPermissinDao.selectListByUserName(result.getuName());
        ((AppUserPermission) result).setPermissionList(appPermissions);
        return (AppUserPermission) result;
    }
}
