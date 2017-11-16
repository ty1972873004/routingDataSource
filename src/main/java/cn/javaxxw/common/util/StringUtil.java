package cn.javaxxw.common.util;

public class StringUtil {
	
	
	 /**
     * 私有构造方法,将该工具类设为单例模式.
     */
    private StringUtil() {
    	
    }
    
	
	 /**
     * 函数功能说明 ： 判断对象是否为空. 修改者名字： 修改日期： 修改内容：
     * 
     * @参数： @param obj
     * @参数： @return
     * @return boolean
     * @throws
     */
    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        }
        if (obj instanceof String) {
            return ((String) obj).trim().isEmpty();
        }
        return !(obj instanceof Number) ? false : false;
    }

}
