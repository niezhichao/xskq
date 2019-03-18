package cloud.nzc.user.service;

import cloud.nzc.model.common.BaseService;
import cloud.nzc.model.po.User;
import cloud.nzc.user.dao.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService  implements BaseService<User> {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(User user) {
        return 0;
    }

    @Override
    public int updateNotEmptyByPrimarykey(User user) {
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
    public User getById(Object id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> getListByParam(User user) {
        return null;
    }

    @Override
    public List<User> getListByIds(List ids) {
        return null;
    }

    @Override
    public int getCount(User user) {
        return 0;
    }
}
