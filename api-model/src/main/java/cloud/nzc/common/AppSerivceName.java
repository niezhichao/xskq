package cloud.nzc.common;

public enum AppSerivceName {
    AUTHSERVICE("auth-server");
    private  String appServiceName;
    public  String getAppServiceName(){
        return this.appServiceName;
    }
    private AppSerivceName(String seriveName){
            this.appServiceName=seriveName;
    }
}
