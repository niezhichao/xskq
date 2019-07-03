package cloud.nzc.user.dao;

import cloud.nzc.model.mybatis.dao.BaseDao;
import cloud.nzc.model.po.AppPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface AppPermissinDao extends BaseDao<AppPermission> {
    AppPermission selectByCode(String code);
    List<AppPermission> selectListByUserName(String username);
}
