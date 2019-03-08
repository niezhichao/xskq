package cloud.nzc.model.util;

import java.util.UUID;

public final class StringUtil {
    public static String getUUID(){
        return  UUID.randomUUID().toString().replace("-","");
    }
}
