package cloud.nzc.model.po;

import cloud.nzc.model.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user")
public class User extends BaseEntity {

    @Id
    @Column(name = "id")
    private String iD;
    @Column(name="uname")
    private  String uName;//用户名
    @Column(name="upwd")
    private  String uPWD;//密码
    @Column(name="ustate")
    private  String ustate;//状态
    @Column(name="name")
    private  String name;//姓名
}
