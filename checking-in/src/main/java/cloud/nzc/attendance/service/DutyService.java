package cloud.nzc.attendance.service;

import cloud.nzc.attendance.dao.DutyDao;
import cloud.nzc.model.common.BaseService;
import cloud.nzc.model.po.Duty;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DutyService implements BaseService<Duty> {
    @Autowired
    private DutyDao dutyDao;
    @Override
    public int insert(Duty duty) {
        return dutyDao.insert(duty);
    }

    @Override
    public int updateByPrimaryKey(Duty duty) {
        return dutyDao.updateByPrimarykey(duty);
    }

    @Override
    public int updateNotEmptyByPrimarykey(Duty duty) {
        return dutyDao.updateNotEmptyByPrimarykey(duty);
    }

    @Override
    public int deleteById(Object id) {
        return 0;
    }

    @Override
    public int deleteByIds(List ids) {
        return 0;
    }

    @Override
    public Duty getById(Object id) {
        return dutyDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Duty> getAll() {
        return dutyDao.selectAll();
    }

    @Override
    public List<Duty> getListByParam(Duty duty) {
        return dutyDao.selectByCondition(duty);
    }

    @Override
    public List<Duty> getListByIds(List ids) {
        return dutyDao.selectByIds(ids);
    }

    @Override
    public int getCount(Duty duty) {
        return dutyDao.selectCount(duty);
    }
}
