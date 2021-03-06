package cloud.nzc.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页信息
 */
public class PageContant extends BaseEntity {
    /*默认起始页*/
    private static  final Integer DEFAULT_PAGENUM=1;
    /*默认页面条数*/
    private static  final Integer DEFAULT_LIMIT=5;
    private Integer pageNum;//当前页数
    private  Integer limit;//每页记录数
    private  Integer total;//总记录数
    private  Integer totalPageNum;//分页总页数
    private  Integer pageStart;//当前页开始

    public  void initPageStart(Integer pageNum,Integer limit){
        this.pageStart=(pageNum-1)*limit;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageNum() {
        if (null==pageNum){
            pageNum= DEFAULT_PAGENUM;
        }
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    public Integer getLimit() {
        if (null==limit){
            limit=DEFAULT_LIMIT;
        }
        return limit;
    }

    public void setLimit(Integer limit) {

        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(Integer totalPageNum) {
        this.totalPageNum = totalPageNum;
    }
}
