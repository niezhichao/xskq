package cloud.nzc.model.common;

import java.io.Serializable;
import java.util.ArrayList;

public class Page<T> extends ArrayList<T> implements Serializable {
    /**
     * 页码
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 总数
     */
    private  int total;
}
