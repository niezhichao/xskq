package cloud.nzc.std.dao;

import cloud.nzc.model.mybatis.dao.BaseDao;
import cloud.nzc.model.po.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface StdDao extends BaseDao<Student> {
}
