package cloud.nzc.model.exception;

import cloud.nzc.model.common.ResultCode;

public class GlobalException extends RuntimeException {
    private ResultCode resultCode;
    public GlobalException(ResultCode resultCode){
        super(resultCode.getMsg());
        this.resultCode=resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
