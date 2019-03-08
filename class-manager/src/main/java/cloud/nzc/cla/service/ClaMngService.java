package cloud.nzc.cla.service;

import cloud.nzc.cla.dao.ClaMngDao;
import cloud.nzc.model.po.ClaMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class ClaMngService {
    @Autowired
    private ClaMngDao claMngDao;

    @Transactional
    public int insert(ClaMng cla) throws Exception {
        return claMngDao.insert(cla);
    }

    @Transactional
    public int deleteClaMngById(String cId) throws Exception {
        return claMngDao.deleteByPrimarykey(cId);
    }

    @Transactional
    public int deleteClaMngByIds(List ids) {
        return claMngDao.deleteList(ids);
    }

    @Transactional
    public int deleteClaMngByCondiction(ClaMng cla) {
        return claMngDao.deleteByCondition(cla);
    }

    @Transactional
    public int updateClaMngByPrimarykey(ClaMng cla) {

        return claMngDao.updateByPrimarykey(cla);
    }

    @Transactional
    public int updateNotEmptyByPrimarykey(ClaMng cla) {

        return claMngDao.updateNotEmptyByPrimarykey(cla);
    }

    public ClaMng getClaMngById(String cId) throws Exception {
        return claMngDao.selectByPrimaryKey(cId);
    }

    public List<ClaMng> getClaMngListByCondition(ClaMng cla) throws Exception {
        List<ClaMng> res = new ArrayList<ClaMng>();
        res = claMngDao.selectByCondition(cla);
        return res;
    }

    public List<ClaMng> getClaMngListByIds(List ids) throws Exception {
        List<ClaMng> res = new ArrayList<ClaMng>();
        res = claMngDao.selectByIds(ids);
        return res;
    }

    public int getClaMngCount(ClaMng cla) throws Exception {
        return claMngDao.selectCount(cla);
    }

    public List<ClaMng> getClaMngAll() throws Exception {
        return claMngDao.selectAll();
    }
}
