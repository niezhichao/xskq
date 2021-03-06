package cloud.nzc.model.common;

public enum  ResultCode {
    SUCCESS("RCD0000","成功"),
    FAIL("RCD0001","失败"),
    ERROR("RCD0002","系统错误"),
    USERNAME_ERROR("RCD0003","账号不存在！"),
    CREDENTIAL_ERROR("RCD0004","账号或密码错误！"),
    PASSWORD_ERROR("RCD0005","密码错误"),
    ACCESSDENY("RCD0006","拒绝访问"),
    CLAINSERTFAIL("RCD0007","班级名称不能为空！"),
    FILEUPLOADFAILED("RCD0008","上传文件为空！");
   private String code;
   private String  msg;
    private ResultCode(String code,String msg){
        this.code=code;
        this.msg=msg;
    }
    public String getCode(){
        return this.code;
    }

    public  String getMsg(){
        return this.msg;
    }
}
