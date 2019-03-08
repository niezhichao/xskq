package cloud.nzc.model.mybatis.provider;

import java.lang.reflect.Field;
import java.util.Map;

/**
 *dao类删除方法provider类
 * @author niezhichao
 */
public class BaseDeleteProvider<T> {

    public  String deleteByCondition(Map<String,Object> para){
        StringBuilder sql=new StringBuilder("delete from ");
        Object obj=para.get("t");
        Class<?> clazz=obj.getClass();
        String tableName=clazz.getSimpleName();
        sql.append(tableName+" "+" where 1=1 ");
        Field[] fields=clazz.getDeclaredFields();
        for (Field field:fields){
            try{
                field.setAccessible(true);
                if (null != field.get(obj)){
                    sql.append(" and ")
                            .append(field.getName()+" =")
                            .append("#{t."+field.getName()+"}");
                }
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }

        }
        return  sql.toString();
    }
}
