package cloud.nzc.common;

import java.util.UUID;

public class StringUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
