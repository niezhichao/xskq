package cloud.nzc.model.mybatis.dao;

import cloud.nzc.model.mybatis.provider.BaseInsertProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

public interface BaseInsertMapper<T> {
    @InsertProvider(type = BaseInsertProvider.class,method = "insertSQL")
    public int insert(@Param("t") T t);
}
