package cloud.nzc.model.mybatis.provider;

import java.lang.reflect.Field;
import java.util.Map;

public class BaseSelectProvider {
    public String selectCount(Map<String,Object> para){
        Class<?> clazz=para.get("t").getClass();
        StringBuilder sql= new StringBuilder("select count(*) from "+clazz.getSimpleName()+" where 1=1 ");
        Field [] fields=clazz.getDeclaredFields();
        for (Field field:fields){
            try{
                field.setAccessible(true);
                if (null != field.get(para.get("t"))){
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

    public String selectByCondition(Map<String,Object> para){
        Class<?> clazz=para.get("t").getClass();
        StringBuilder sql= new StringBuilder("select * from "+clazz.getSimpleName()+" where 1=1 ");
        Field [] fields=clazz.getDeclaredFields();
        for (Field field:fields){
            try{
                field.setAccessible(true);
                if (null != field.get(para.get("t"))){
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
