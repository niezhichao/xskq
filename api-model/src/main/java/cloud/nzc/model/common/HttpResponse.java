package cloud.nzc.model.common;

import com.netflix.ribbon.proxy.annotation.Http;

/**
 * @Title 结果信息类
 * @Author: zhichao nie
 * @CreateDate: 2019/03/18
 */
public class HttpResponse<T> extends BaseEntity {
    private  String code;
    private  String msg;
    private  T resultData;
    public HttpResponse() {
    }

    /**
     *成功后调用
     * @param data
     * @param <T> static 要加泛型<T> 是指定要return的HtttpResponse的类型.
     * @return
     */
    public static  <T>  HttpResponse<T> success(T data){
        return new HttpResponse<>(data);
    }

    public static <T> HttpResponse<T> error(ResultCode resultCode,T data){
        return new HttpResponse<>(resultCode,data);
    }

    public  HttpResponse(ResultCode resultCode,T resultData){
        this.code=resultCode.getCode();
        this.msg=resultCode.getMsg();
        this.resultData=resultData;
    }

    public HttpResponse(ResultCode resultCode){
        this.code=resultCode.getCode();
        this.msg=resultCode.getMsg();
    }

    public  HttpResponse(T resultData){
        this.resultData=resultData;
    }
    public HttpResponse(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public HttpResponse(String code,String msg,T data){
        this.msg=msg;
        this.code=code;
        this.resultData=data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }
}
