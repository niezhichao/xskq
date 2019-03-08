package cloud.nzc.model.mybatis.provider;

import java.lang.reflect.Field;
import java.util.Map;

public class BaseUpdateProvider {

    public  String updateNotEmptyByPrimarykey(Map<String,Object> para){
        StringBuilder sql=new StringBuilder();
        Class<?> clazz=para.get("t").getClass();
        Object obj=para.get("t");
        sql.append("update "+clazz.getSimpleName()+" set ");
        String id="iD";
        Field[] fields=clazz.getDeclaredFields();
        for (Field field:fields){
            try{
                field.setAccessible(true);
                if (null != field.get(obj)){
                    //不分大小写，属性名和主键名相同就进入下一个循环
                    if (field.getName().equalsIgnoreCase(id)){
                        continue;
                    }
                        sql.append(field.getName()+" = "+"#{t."+field.getName()+"},");
                }
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
        sql.replace(sql.length()-1,sql.length(),"").append(" where "+id+"= #{t."+id+"}");
        return  sql.toString();
    }
}
