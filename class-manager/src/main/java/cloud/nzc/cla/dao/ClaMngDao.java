package cloud.nzc.cla.dao;

import cloud.nzc.model.mybatis.dao.BaseDao;
import cloud.nzc.model.po.ClaMng;
import cloud.nzc.model.vo.ClaMngVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ClaMngDao extends BaseDao<ClaMng> {

    List<ClaMng> selectClaMngListByCondition(ClaMngVo claMngVo);
}
