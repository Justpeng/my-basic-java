package com.just.module.ip.common;

import com.just.module.ip.pojo.Ip;

import java.util.List;

/**
 * @author:Just
 * @create:2016-10-31 22:23
 */
public class PageParam {
    private int currPage;
    private int totalPage;
    private int rowCount;

    private List<Ip> data;

    public static int pageSize = 6;

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        int totalPage = rowCount/pageSize;
        if (rowCount % totalPage >= 0) {
            totalPage +=1;
        }
        setTotalPage(totalPage);
        this.rowCount = rowCount;
    }

    public List<Ip> getData() {
        return data;
    }

    public void setData(List<Ip> data) {
        this.data = data;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
