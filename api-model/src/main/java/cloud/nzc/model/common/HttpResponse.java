package cloud.nzc.model.common;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class HttpResponse extends BaseEntity {
    private static Logger logger = LoggerFactory.getLogger(HttpResponse.class);
    private int status;
    private String massage;
    private Object data;
    private String errorCode;

    public HttpResponse() {
    }

    public HttpResponse(int status, String massage, Object data) {
        this.status = status;
        this.massage = massage;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Object getData() {
        return data;
    }

    public <T> T getData(Class<T> clazz) {
        if (this.data instanceof Map) {
            return new JSONObject((Map) this.data).toJavaObject(clazz);
        }
        return (T) this.data;
    }

    public <T> List<T>  getPage(Class<T> clazz){
        if (this.data instanceof List ){
            JSONArray jsonArray=new JSONArray((List)this.data);
            return JSONArray.parseArray(jsonArray.toJSONString(),clazz);
        }
        return  (List<T>) this.data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public  static  HttpResponse success(Object data){
        return  new HttpResponse(200,"",data);
    }

    public  static  HttpResponse success(String message,Object data){
        return  new HttpResponse(200,message,data);
    }

    public  static  HttpResponse error(int status ,String message){
        logger.error(message);
        return new  HttpResponse(status,message,"");
    }


}
