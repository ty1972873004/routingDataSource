package cn.javaxxw.common.datasource;

/**
 * @author tuyong
 * @version 1.0
 * @desc
 * @create 2017-11-16 15:18
 **/
public class HandleDataSource {

    /**
     * 数据源名称线程池
     */
    public static final ThreadLocal<String> holder = new ThreadLocal<String>();

    public static void putDataSource(String datasource) {
        holder.set(datasource);
    }

    public static String getDataSource() {
        return holder.get();
    }
}
