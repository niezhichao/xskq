package cloud.nzc.model.po;

import cloud.nzc.model.common.BaseEntity;

import javax.persistence.Table;

/**
 * 用户角色
 */
@Table(name = "appRole")
public class AppRole extends BaseEntity {
    private String id;
    private String  roleId;
    private String  roleName;

    public AppRole() {
    }

    public AppRole(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
