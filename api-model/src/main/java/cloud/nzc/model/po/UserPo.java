package cloud.nzc.model.po;

import cloud.nzc.model.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="user")
public class UserPo extends  BaseEntity{

    @Id
    @Column(name = "uid")
    private String uId;
    @Column(name="uname")
    private  String uName;//用户名
    @Column(name="upwd")
    private  String uPWD;//密码
    @Column(name="ustate")
    private  String ustate;//状态
    @Column(name="realName")
    private  String realName;//姓名
    public UserPo(String username){
        this.uName=username;
    }

    public UserPo() {
        super();
    }

    @Override
    public String toString() {
        return "UserPo{" +
                "uId='" + uId + '\'' +
                ", uName='" + uName + '\'' +
                ", uPWD='" + uPWD + '\'' +
                ", ustate='" + ustate + '\'' +
                ", name='" + realName + '\'' +
                '}';
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public UserPo(String uId, String uName, String uPWD, String ustate, String name) {

        this.uId = uId;
        this.uName = uName;
        this.uPWD = uPWD;
        this.ustate = ustate;
        this.realName = name;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPWD() {
        return uPWD;
    }

    public void setuPWD(String uPWD) {
        this.uPWD = uPWD;
    }

    public String getUstate() {
        return ustate;
    }

    public void setUstate(String ustate) {
        this.ustate = ustate;
    }

    public String getName() {
        return realName;
    }

    public void setName(String name) {
        this.realName = name;
    }


}
