package cloud.nzc.gateway.filter;

import cloud.nzc.common.CookieUtil;
import cloud.nzc.gateway.service.AuthTokenService;
import cloud.nzc.model.common.HttpResponse;
import cloud.nzc.model.common.ResultCode;
import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter extends ZuulFilter {
    @Autowired
    AuthTokenService authTokenService;
    public LoginFilter() {
        super();
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器内容
     *
     * 过滤所有请求，简单身份校验
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();
        //得到response
        HttpServletResponse response = requestContext.getResponse();
        String access_token=authTokenService.getTokenFromCookie(request);
        if(StringUtils.isEmpty(access_token)){
            this.accessDeny(requestContext,response);
            return null;
        }
        String jwtFromHeader=authTokenService.getJWTFromHeader(request);
        if(StringUtils.isEmpty(jwtFromHeader)){
            this.accessDeny(requestContext,response);
            return null;
        }
        Long expire=authTokenService.getExpire(access_token);
        if(expire<0){
            this.accessDeny(requestContext,response);
            return null;
        }
        return null;
    }

    @Override
    public boolean isStaticFilter() {
        return super.isStaticFilter();
    }

    @Override
    public String disablePropertyName() {
        return super.disablePropertyName();
    }

    @Override
    public boolean isFilterDisabled() {
        return super.isFilterDisabled();
    }

    @Override
    public ZuulFilterResult runFilter() {
        return super.runFilter();
    }

    @Override
    public int compareTo(ZuulFilter filter) {
        return super.compareTo(filter);
    }

    /**
     * 过滤器类型
     * pre 请求在路由之前
     * routing 路由请求时
     * post: routing和error之后
     * error
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 拒绝访问
     */
    private  void accessDeny(RequestContext requestContext,HttpServletResponse response){
        requestContext.setSendZuulResponse(false);
        requestContext.setResponseStatusCode(200);
        HttpResponse httpResponse=new HttpResponse(ResultCode.ACCESSDENY);
        String jsonString= JSON.toJSONString(httpResponse);
        requestContext.setResponseBody(jsonString);
        response.setContentType("application/json;charset=utf-8");
    }
}
