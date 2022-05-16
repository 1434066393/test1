package com.youjiuye.utils;

import com.youjiuye.entity.Student;

import java.util.List;

/*分页工具类*/
public class PageBean {

    private int currentPage; //当前页      页面传递
    private int pageSize;//每页显示条数     页面传递
    private int totalPage;//总页数         通过总条数与每页显示条数计算
    private int totalCount;//总条数        查询数据库

    private List<Student> list;//用户想看的数据 通过用户想看的页码 每页显示条数 查询条件 查询数据得到

    public PageBean(){

    }

    public PageBean(int currentPage, int pageSize, int totalPage, int totalCount, List<Student> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
}
