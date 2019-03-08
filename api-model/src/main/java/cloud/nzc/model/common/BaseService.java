package cloud.nzc.model.common;

import java.util.List;

public interface BaseService<T> {
    int insert(T t);
    int updateByPrimaryKey(T t);
    int updateNotEmptyByPrimarykey(T t);
    int deleteById(Object id);
    int deleteByIds(List ids);
    T getById(Object id);
    List<T> getAll();
    List<T> getListByParam(T t);
    List<T> getListByIds(List ids);
    int getCount(T t);
}
