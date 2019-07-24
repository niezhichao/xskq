package cloud.nzc.common;

import cloud.nzc.model.common.ResultCode;
import cloud.nzc.model.exception.GlobalException;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

    public static void  uploadFile(MultipartFile multipartFile,String fileName,String filePath){

        if (multipartFile.isEmpty()){
            throw  new GlobalException(ResultCode.FILEUPLOADFAILED);
        }
    }
}
