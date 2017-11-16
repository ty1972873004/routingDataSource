package cn.javaxxw.common.page;

import java.io.Serializable;

import javax.servlet.jsp.tagext.SimpleTagSupport;


public class Page extends SimpleTagSupport implements Serializable {

    private static final long serialVersionUID = 1L;//序列号
    private Integer current;//当前页码
    private Long count;//记录总数
    private Integer pageCount;//每页记录数

    public Page() {
        this.current = 1; // 默认第一页
        this.count = 0L; // 共多少条记录
        this.pageCount = 10; // 默认每页10条记录
    }

  
    /**
     * 获取总记录条数
     *
     * @return
     */
    public Long getCount() {
        return this.count;
    }

    /**
     * 设置总记录条数
     *
     * @param count
     */
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * 获取当前第几页
     *
     * @return
     */
    public Integer getCurrent() {
        return this.current;
    }

    /**
     * 设置当前第几页
     *
     * @param current
     */
    public void setCurrent(Integer current) {
        try {
            if (current <= 0) {
                this.current = 1;
            } else {
                this.current = current;
            }
        } catch (Exception e) {
            this.current = 1;
        }
    }

    /**
     * 获取每页多少条记录
     *
     * @return
     */
    public Integer getPageCount() {
        return this.pageCount;
    }

    /**
     * 设置每页多少条记录
     *
     * @param pageCount
     */
    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

  

    /**
     * 获取总页数
     *
     * @return
     */
    public int getPages() {
        if (this.count % this.pageCount == 0) {
            return (int) (this.count / this.pageCount);
        } else {
            return (int) (this.count / this.pageCount + 1);
        }
    }

    /**
     * 是否为第一页
     *
     * @return
     */
    public boolean firstEnable() {
        return previoEnable();
    }

    /**
     * 是否为最后一页
     *
     * @return
     */
    public boolean lastEnable() {
        return nextEnable();
    }

    /**
     * 是否有下一页
     *
     * @return
     */
    public boolean nextEnable() {
        return this.current * this.pageCount < this.count;
    }

    /**
     * 是否有上一页
     *
     * @return
     */
    public boolean previoEnable() {
        return this.current > 1;
    }

    /**
     * 获取任一页第一条数据在数据集的位置.
     *
     * @param pageNo 从1开始的页号
     * @param pageSize 每页记录条数
     * @return 该页第一条数据
     */
    public int getStartOfPage(long pageNo, long pageSize) {
        return (int) ((pageNo - 1) * pageSize);
    }
}