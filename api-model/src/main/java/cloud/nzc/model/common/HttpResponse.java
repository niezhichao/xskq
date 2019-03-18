package cloud.nzc.model.common;

/**
 * @Title 结果信息类
 * @Author: zhichao nie
 * @CreateDate: 2019/03/18
 */
public class HttpResponse<T> extends BaseEntity {

    private  String resultCode;
    private  String resultMsg;
    private  T resultData;
    public HttpResponse() {
    }

    public HttpResponse(String resultCode, String resultMsg, T resultData) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultData = resultData;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public T getResultData() {
        return resultData;
    }

    public void setResultData(T resultData) {
        this.resultData = resultData;
    }
}
