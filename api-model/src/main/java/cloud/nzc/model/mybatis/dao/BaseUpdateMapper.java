package cloud.nzc.model.mybatis.dao;

import cloud.nzc.model.mybatis.provider.BaseUpdateProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.UpdateProvider;
import org.assertj.core.util.diff.Delta;

public interface BaseUpdateMapper<T> {
    /*根据主键更新所有字段，null值会被更新*/
    int updateByPrimarykey(@Param("t") T t);
    /*根据主键更新非null字段*/
    int updateNotEmptyByPrimarykey(@Param("t") T t);
}
