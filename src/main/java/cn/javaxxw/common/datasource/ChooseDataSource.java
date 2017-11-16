package cn.javaxxw.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author tuyong
 * @version 1.0
 * @desc 获取数据源
 * @create 2017-11-16 15:18
 **/
public class ChooseDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return HandleDataSource.getDataSource();
    }
}
