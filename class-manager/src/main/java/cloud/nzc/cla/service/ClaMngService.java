package cloud.nzc.cla.service;

import cloud.nzc.cla.dao.ClaMngDao;
import cloud.nzc.model.common.PageContant;
import cloud.nzc.model.common.PageInPo;
import cloud.nzc.model.po.ClaMng;
import cloud.nzc.model.vo.ClaMngVo;
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

    public PageInPo<ClaMng> getClaMngPageByCondition(ClaMngVo claMngVo){
        claMngVo.initPageStart(claMngVo.getPageNum(),claMngVo.getLimit());
        List<ClaMng> claMngs=claMngDao.selectClaMngListByCondition(claMngVo);
        Integer total=claMngDao.selecTotalByCondition(claMngVo);
        PageInPo<ClaMng> claMngPage=new PageInPo();
        claMngPage.setTotal(total);
        claMngPage.setData(claMngs);
        claMngPage.setPageNum(claMngVo.getPageNum());
        claMngPage.setPageSize(claMngVo.getLimit());
        claMngPage.setTotal(claMngPage.getTotal());
        return claMngPage;
    }
}
