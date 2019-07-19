package cloud.nzc.auth.controller;

import cloud.nzc.api.auth.AuthControllerApi;
import cloud.nzc.auth.service.AuthService;
import cloud.nzc.common.CookieUtil;
import cloud.nzc.model.auth.AuthToken;
import cloud.nzc.model.exception.GlobalException;
import cloud.nzc.model.common.HttpResponse;
import cloud.nzc.model.common.ResultCode;
import cloud.nzc.model.po.UserPo;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  niezhihcao
 *
 * @Date 2018.05.04
 *Login interface
 */

@RestController
@RequestMapping("/")
public class AuthController implements AuthControllerApi {
    @Autowired
    AuthService authService;
    @Value("${auth.clientId}")
    String cilentId;
    @Value("${auth.clientSecret}")
    String clientSecret;
    @Value("${auth.cookieMaxAge}")
    int cookieMaxAge;
    @Value("${auth.cookieDomain}")
    String cookieDomain;
    private final static Logger log=LoggerFactory.getLogger(AuthController.class);
    @Override
    @PostMapping("/userLogin")
    public HttpResponse login(UserPo user) {
        log.info("------------user login-----------");
        AuthToken authToken=null;
        if (user==null || StringUtils.isEmpty(user.getuName())){
            log.error("In  AuthController method login: error is that the username is null");
            throw new GlobalException(ResultCode.USERNAME_ERROR);
        }
        authToken=authService.loging(user.getuName(),user.getuPWD(),cilentId,clientSecret);
        String access_token=authToken.getAccess_token();
        this.savaTokenToCookie(access_token);
        return new HttpResponse(ResultCode.SUCCESS,access_token);
    }
    @Override
    @GetMapping("")
    public HttpResponse logout() {
        return null;
    }

    @Override
    @PostMapping("/userjwt")
    public HttpResponse getJWT(String access_token) {
        HttpServletRequest request=((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        response.setHeader( "Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");//
        response.addHeader( "Access-Control-Allow-Origin", "*" ); //可以访问此域资源的域。*为所有
        response.addHeader( "Access-Control-Allow-Methods", "POST" );
        AuthToken authToken =authService.getTokenFromReids(access_token);
        String  res=authToken.getJwt_token();
        return new HttpResponse(ResultCode.SUCCESS,res);
    }

    /**
     * 将令牌存储到cookie
     */
    private void savaTokenToCookie(String token ){
        HttpServletResponse response=((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        Map<String,Object> mapParam=new HashMap<>();
        mapParam.put("name","uid");
        mapParam.put("value",token);
        mapParam.put("domain",cookieDomain);
        mapParam.put("path","/");
        mapParam.put("maxAge",cookieMaxAge);
        mapParam.put("httpOnly",false);
        CookieUtil.addCookie(mapParam);
    }
}
