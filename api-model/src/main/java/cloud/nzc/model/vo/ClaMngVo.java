package cloud.nzc.model.vo;

import cloud.nzc.model.common.PageContant;

public class ClaMngVo extends PageContant {
    private String iD;
    private String cName;//班级名
    private String cRemark;//备注

    public ClaMngVo() {
    }

    public ClaMngVo(String cName, String cRemark) {
        this.cName = cName;
        this.cRemark = cRemark;
    }

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
}
