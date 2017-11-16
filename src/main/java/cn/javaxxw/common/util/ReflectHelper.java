package cn.javaxxw.common.util;

import java.lang.reflect.Field;  
import java.lang.reflect.ParameterizedType;  
import java.lang.reflect.Type;

import org.apache.log4j.Logger;

public class ReflectHelper {    
	
	private static final Logger log = Logger.getLogger(ReflectHelper.class); 
    
      
    /**  
     * 获取obj对象fieldName的Field  
     * @param obj  
     * @param fieldName  
     * @return  
     */    
    public static Field getFieldByFieldName(Object obj, String fieldName) {    
        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass    
                .getSuperclass()) {    
            try {    
                return superClass.getDeclaredField(fieldName);    
            } catch (NoSuchFieldException e) {    
            }    
        }    
        return null;    
    }    
    
    /**  
     * 获取obj对象fieldName的属性�?  
     * @param obj  
     * @param fieldName  
     * @return  
     * @throws SecurityException  
     * @throws NoSuchFieldException  
     * @throws IllegalArgumentException  
     * @throws IllegalAccessException  
     */    
    public static Object getValueByFieldName(Object obj, String fieldName)    
            throws SecurityException, NoSuchFieldException,    
            IllegalArgumentException, IllegalAccessException {    
        Field field = getFieldByFieldName(obj, fieldName);    
        Object value = null;    
        if(field!=null){    
            if (field.isAccessible()) {    
                value = field.get(obj);    
            } else {    
                field.setAccessible(true);    
                value = field.get(obj);    
                field.setAccessible(false);    
            }    
        }    
        return value;    
    }    
    
    /**  
     * 设置obj对象fieldName的属性�?  
     * @param obj  
     * @param fieldName  
     * @param value  
     * @throws SecurityException  
     * @throws NoSuchFieldException  
     * @throws IllegalArgumentException  
     * @throws IllegalAccessException  
     */    
    public static void setValueByFieldName(Object obj, String fieldName,    
            Object value) throws SecurityException, NoSuchFieldException,    
            IllegalArgumentException, IllegalAccessException {    
        Field field = obj.getClass().getDeclaredField(fieldName);    
        if (field.isAccessible()) {    
            field.set(obj, value);    
        } else {    
            field.setAccessible(true);    
            field.set(obj, value);    
            field.setAccessible(false);    
        }    
    }    
    /** 
     * 通过java反射，获得定义类时声明的基类(父类)的泛型参数的类型. 
     * 如类声明：public UserDao extends HibernateDao &lt;com.mass.demo.User&gt; ...,�? 
     * 调用本方法语句getSuperClassGenericType(UserDao.class,0)返回User.class. 
     *  
     * @param clazz - 子类Class 
     * @param index - 基类层级 
     * @return 基类(父类)的泛型参数的类型 
     */  
    @SuppressWarnings("rawtypes")
	public static Class getSuperClassGenericType(final Class clazz, final int index){  
        Type genericType = clazz.getGenericSuperclass();  
        if(!(genericType instanceof ParameterizedType)){  
            return Object.class;  
        }  
        Type[] params = ((ParameterizedType) genericType).getActualTypeArguments();  
          
          
        if(index>=params.length || index < 0){  
            log.warn("Index:"+index+",size of "+clazz.getSimpleName()+"'s Parameterize Type:"+params.length);  
            return Object.class;  
        }  
        if(!(params[index] instanceof Class)){  
            return Object.class;  
        }  
        return (Class)params[index];   
    }  
}    