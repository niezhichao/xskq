package cloud.nzc.model.mybatis.dao;


public interface BaseDao<T> extends
        BaseDeleteMapper<T>,
        BaseInsertMapper<T>,
        BaseSelectMapper<T>,
        BaseUpdateMapper<T> {

}
