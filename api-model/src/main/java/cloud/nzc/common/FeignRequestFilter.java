package cloud.nzc.common;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

public class FeignRequestFilter implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        Enumeration<String> headerNames= request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName=headerNames.nextElement();
            String headerValue=request.getHeader(headerName);
            requestTemplate.header(headerName,headerValue);
        }
    }
}
