package cloud.nzc.model.exception;


import cloud.nzc.model.common.HttpResponse;
import cloud.nzc.model.common.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author niezhichao
 * @create 2019-06-01 13:45
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 拦截处理自定义异常
     *
     * @param ex 自定义全局异常
     * @return
     */
    @ExceptionHandler(GlobalException.class)
    @ResponseBody
    public HttpResponse handleGlobalException(GlobalException ex) {
        ex.printStackTrace();
        //记录日志
        log.error("catch exception:{}", ex.getMessage());
        ResultCode resultCode = ex.getResultCode();
        return new HttpResponse(resultCode);
    }

    /**
     * 其他异常处理
     *
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public HttpResponse handleException(Exception ex) {
        ex.printStackTrace();
        //记录日志
        log.error("catch exception:{}", ex.getMessage());
        return new HttpResponse(ResultCode.ERROR, ex.getMessage());
    }
}
