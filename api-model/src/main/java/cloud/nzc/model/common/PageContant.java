package cloud.nzc.model.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageContant<T> extends BaseEntity {
    private static final long serialVersionUID = -275582248840137389L;
    private Integer page;//当前页数
    private  Integer limit;//每页记录数
    private  int total;//总记录数
    private List<T> data;
}
