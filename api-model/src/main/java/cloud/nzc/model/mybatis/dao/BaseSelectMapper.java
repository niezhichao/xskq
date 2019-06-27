package cloud.nzc.model.mybatis.dao;

import cloud.nzc.model.mybatis.provider.BaseSelectProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface BaseSelectMapper<T> {
    /**
     * 主键id查询
     * @param key
     * @return
     */
    T selectByPrimaryKey(Object key);
    /**
     * 条件查询
     */
    List<T> selectByCondition(@Param("t") T t);

    /**
     * 根据条件查询总数
     * @param t
     * @return
     */
    int selectCount(@Param("t")T t);
    /**
     * 查询全部
     * @return
     */
    List<T> selectAll();
    /**
     * 多个id查询
     */
    List<T> selectByIds(List<Object> ids);
}
