package cloud.nzc.api.auth;

import cloud.nzc.model.common.HttpResponse;
import cloud.nzc.model.po.UserPo;

public interface AuthControllerApi {
   public  HttpResponse login(UserPo user);
    public  HttpResponse logout();
    public  HttpResponse getJWT(String access_token);
}
