package cloud.nzc.model.mybatis.dao;

import cloud.nzc.model.mybatis.provider.BaseDeleteProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDeleteMapper<T> {
    /**
     *主键条件删除
     * @param key
     * @return
     */
    int deleteByPrimarykey(Object key);

    /**
     *多个id删除
     * @param ids
     * @return
     */
    int deleteList(List<Object> ids);

    /**
     * 多条件删除
     * @param t
     * @return
     */
    @DeleteProvider(type = BaseDeleteProvider.class,method = "deleteByCondition")
    int deleteByCondition(@Param("t") T t);
}
