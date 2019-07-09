package cloud.nzc.model.po;

import cloud.nzc.model.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "claMng")
public class ClaMng extends BaseEntity {

    @Id
    @Column(name = "id")
        private String iD;
    @Column(name = "cname")
    private String cName;//班级名
    @Column(name = "cremark")
    private String cRemark;//备注

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark;
    }

    @Override
    public String toString() {
        return "ClaMng{" +
                "iD='" + iD + '\'' +
                ", cName='" + cName + '\'' +
                ", cRemark='" + cRemark + '\'' +
                '}';
    }
}
