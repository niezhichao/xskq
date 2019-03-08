package cloud.nzc.model.mybatis.provider;

import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.Map;

public class BaseInsertProvider {

    public  String insertSQL(Map<String,Object> para){
        Class<?> clazz=para.get("t").getClass();
        Field[] fields= clazz.getFields();
        Field[] declaredFields=clazz.getDeclaredFields();
        StringBuilder sql= new StringBuilder("insert into ");
        sql.append(clazz.getSimpleName())
            .append(" values(");
        for (Field field: declaredFields) {
            sql.append("#{")
                    .append("t."+field.getName()+"}")
                    .append(",");

        }
        //sql语句末尾多余的逗号去除
        sql.replace(sql.length()-1,sql.length(),")");
        return sql.toString();
    }
}
