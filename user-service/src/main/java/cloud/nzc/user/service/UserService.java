package cloud.nzc.user.service;

import cloud.nzc.model.common.BaseService;
import cloud.nzc.model.po.UserPo;
import cloud.nzc.user.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
@Service
public class UserService  implements BaseService<UserPo> {
    @Autowired
    private UserMapper userMapper;
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
}
