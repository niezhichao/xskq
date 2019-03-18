package cloud.nzc.user.dao;

import cloud.nzc.model.mybatis.dao.BaseDao;
import cloud.nzc.model.po.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseDao<User> {

}
