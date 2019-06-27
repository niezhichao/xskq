package cloud.nzc.model.mybatis.dao;

import cloud.nzc.model.mybatis.provider.BaseInsertProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

public interface BaseInsertMapper<T> {
    public int insert(@Param("t") T t);
}
