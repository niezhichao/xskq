package cloud.nzc.common;

import com.netflix.client.http.HttpResponse;
import com.netflix.ribbon.proxy.annotation.Http;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CookieUtil {
    /**
     * 添加cookie
     * @param map
     */
    public  static  void addCookie(Map map){
        String name=(String)map.get("name");//cookie名称
        String value=(String)map.get("value");//cookie存储的值
        String domain=(String)map.get("domain");
        String path=(String)map.get("path");
        int maxAge=(int)map.get("maxAge");//生命周期 秒为单位
        boolean httpOnly=(boolean)map.get("httpOnly");
        Cookie cookie=new Cookie(name,value);
        cookie.setDomain(domain);
        cookie.setPath(path);
        cookie.setHttpOnly(httpOnly);
        cookie.setMaxAge(maxAge);

    }

    /**
     * 根据cookie名称读取cookie
     * @param request
     * @param cookieNames
     * @return map<cookieName,cookieValue>
     */

    public static Map<String,String> readCookie(HttpServletRequest request, String ... cookieNames) {
        Map<String,String> cookieMap = new HashMap<String,String>();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                String cookieValue = cookie.getValue();
                for(int i=0;i<cookieNames.length;i++){
                    if(cookieNames[i].equals(cookieName)){
                        cookieMap.put(cookieName,cookieValue);
                    }
                }
            }
        }
        return cookieMap;

    }
}
