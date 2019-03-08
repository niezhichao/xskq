package cloud.nzc.model.po;

import cloud.nzc.model.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="duty")
public class Duty extends BaseEntity {

    @Id
    @Column(name = "id")
    private String iD;
    @Column(name="uid")
    private  String uId;//用户编号
    @Column(name="dstate")
    private  String dState;//考勤状态
    @Column(name="ddate")
    private  Date dDate;//考勤时间
    @Column(name="dremark")
    private  String dRemark;//备注
    @Column(name="cid")
    private  String cId;//班级编号
}
