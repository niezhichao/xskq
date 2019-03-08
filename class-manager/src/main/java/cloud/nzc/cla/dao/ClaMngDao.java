package cloud.nzc.cla.dao;

import cloud.nzc.model.mybatis.dao.BaseDao;
import cloud.nzc.model.po.ClaMng;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
@Mapper
@Repository
public interface ClaMngDao extends BaseDao<ClaMng> {

}
