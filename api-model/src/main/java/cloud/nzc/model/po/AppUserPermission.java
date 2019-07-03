package cloud.nzc.model.po;

;


import java.util.List;


public class AppUserPermission  extends  UserPo{
    private List<AppPermission> permissionList;//用户权限
    private String status;
    public AppUserPermission(UserPo userPo){
        super(userPo.getuId(), userPo.getuName(), userPo.getuPWD(),userPo.getUstate(), userPo.getRealName());
    }
    public List<AppPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<AppPermission> permissionList) {
        this.permissionList = permissionList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String res=super.toString();
        if (null !=permissionList){
            res=super.toString()+permissionList.toString();
        }
        return res;
    }
}
