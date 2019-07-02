package cloud.nzc.user.dao;

import cloud.nzc.model.mybatis.dao.BaseDao;
import cloud.nzc.model.po.UserPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper extends BaseDao<UserPo> {



}
