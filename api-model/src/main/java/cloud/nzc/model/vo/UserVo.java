package cloud.nzc.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.security.auth.login.AppConfigurationEntry;
import java.util.Collection;

public class UserVo  {


    private String iD;
    private  String uName;//用户名
    private  String uPWD;//密码
    private  String ustate;//状态
    private  String name;//姓名

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
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
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
