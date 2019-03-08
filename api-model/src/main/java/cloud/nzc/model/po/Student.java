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
@Table(name="student")
public class Student extends BaseEntity {

    @Id
    @Column(name = "id")
    private String iD;
    @Column(name="cid")
    private  String cId;//班级
    @Column(name="sname")
    private  String sName;//姓名
    @Column(name="sstate")
    private  String sState;//状态
    @Column(name="sex")
    private  String sex;//性别
    @Column(name="birth")
    private  Date birth;//生日
    @Column(name="tel")
    private  String tel;//电话
    @Column(name="mobiletel")
    private  String mobileTel;//手机号
    @Column(name="remark")
    private   String remark;//备注
}
