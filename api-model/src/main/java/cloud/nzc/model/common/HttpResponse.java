package cloud.nzc.model.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title 结果信息类
 * @Author: zhichao nie
 * @CreateDate: 2019/03/18
 */
public class HttpResponse extends  PageContant {
    private  final  static Logger log=LoggerFactory.getLogger(HttpResponse.class);
    private  String code;
    private  String msg;
    private  Object resultData;
    public HttpResponse() {
    }

    /**
     *成功后调用
     * @param data
     * @return
     */
    public static  HttpResponse success(Object data){
        return new HttpResponse(ResultCode.SUCCESS,data);
    }

    public static  HttpResponse error(ResultCode resultCode,String msg){
        log.error(msg);
        return new HttpResponse(resultCode,msg);
    }

    public  HttpResponse(ResultCode resultCode,Object resultData){
        this.code=resultCode.getCode();
        this.msg=resultCode.getMsg();
        this.resultData=resultData;
    }

    public HttpResponse(ResultCode resultCode){
        this.code=resultCode.getCode();
        this.msg=resultCode.getMsg();
    }

    public  HttpResponse(Object resultData){
        this.resultData=resultData;
    }
    public HttpResponse(String code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public HttpResponse(String code,String msg,Object data){
        this.msg=msg;
        this.code=code;
        this.resultData=data;
    }
    public static HttpResponse toPage(PageInPo page){
        HttpResponse res=new HttpResponse(ResultCode.SUCCESS,page.getData());
        res.setLimit(page.getPageSize());
        res.setPageNum(page.getPageNum());
        res.setTotal(page.getTotal());
        return res;
    }
    /**
     * 返回的视图page对象
     * @return
     */
    /*public static HttpResponse toPage(){

    }*/
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

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
}
