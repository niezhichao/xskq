package cloud.nzc.attendance.service;

import cloud.nzc.attendance.dao.DutyListDao;
import cloud.nzc.model.common.BaseService;
import cloud.nzc.model.po.DutyList;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DutyListSerivce implements BaseService<DutyList> {
    @Autowired
    private DutyListDao dutyListDao;

    @Override
    public int insert(DutyList dutyList) {
        return dutyListDao.insert(dutyList);
    }

    @Override
    public int updateByPrimaryKey(DutyList dutyList) {
        return dutyListDao.updateByPrimarykey(dutyList);
    }

    @Override
    public int updateNotEmptyByPrimarykey(DutyList dutyList) {
        return dutyListDao.updateNotEmptyByPrimarykey(dutyList);
    }

    @Override
    public int deleteById(Object id) {
        return dutyListDao.deleteByPrimarykey(id);
    }

    @Override
    public int deleteByIds(List ids) {
        return dutyListDao.deleteList(ids);
    }

    @Override
    public DutyList getById(Object id) {
        return dutyListDao.selectByPrimaryKey(id);
    }

    @Override
    public List<DutyList> getAll() {
        return dutyListDao.selectAll();
    }

    @Override
    public List<DutyList> getListByParam(DutyList dutyList) {
        return dutyListDao.selectByCondition(dutyList);
    }

    @Override
    public List<DutyList> getListByIds(List ids) {
        return dutyListDao.selectByIds(ids);
    }

    @Override
    public int getCount(DutyList dutyList) {
        return dutyListDao.selectCount(dutyList);
    }
}
