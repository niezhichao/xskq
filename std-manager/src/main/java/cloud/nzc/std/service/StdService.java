package cloud.nzc.std.service;

import cloud.nzc.model.common.BaseService;
import cloud.nzc.model.po.Student;
import cloud.nzc.std.dao.StdDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Component
public class StdService implements BaseService<Student> {
    @Autowired
    private StdDao stdDao;

    @Override
    @Transactional
    public int insert(Student student) {
        return stdDao.insert(student);
    }

    @Override
    @Transactional
    public int updateByPrimaryKey(Student student) {
        return stdDao.updateByPrimarykey(student);
    }

    @Override
    @Transactional
    public int updateNotEmptyByPrimarykey(Student student) {
        return stdDao.updateNotEmptyByPrimarykey(student);
    }

    @Override
    @Transactional
    public int deleteById(Object id) {
        return 0;
    }

    @Override
    @Transactional
    public int deleteByIds(List ids) {
        return 0;
    }

    @Override
    public Student getById(Object id) {
        return stdDao.selectByPrimaryKey(id);
    }

    @Override
    public List<Student> getAll() {
        return stdDao.selectAll();
    }

    @Override
    public List<Student> getListByParam(Student student) {
        return stdDao.selectByCondition(student);
    }

    @Override
    public List<Student> getListByIds(List ids) {
        return stdDao.selectByIds(ids);
    }

    @Override
    public int getCount(Student student) {
        return stdDao.selectCount(student);
    }
}
