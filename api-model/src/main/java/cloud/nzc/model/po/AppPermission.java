package cloud.nzc.model.po;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户权限实体类
 */
@Table(name="appPermission")
public class AppPermission {
    @Id
    private String id;
    @Column(name ="p_code")
    private String p_code;
    @Column(name ="p_name")
    private String p_name;

    public String getP_code() {
        return p_code;
    }

    public void setP_code(String p_code) {
        this.p_code = p_code;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public AppPermission(String code) {
        this.p_code = code;
    }

    public AppPermission() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return p_code;
    }

    public void setCode(String code) {
        this.p_code = code;
    }
}
