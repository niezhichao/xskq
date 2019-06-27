package cloud.nzc.model.common;

import cloud.nzc.model.exception.GlobalException;

/**
 * @author Administrator
 * @version 1.0
 * @create 2018-09-14 17:31
 **/
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new GlobalException(resultCode);
    }
}
