package com.youjiuye.service;

import com.youjiuye.dao.StudentDao;
import com.youjiuye.entity.Student;
import com.youjiuye.utils.PageBean;

import java.util.ArrayList;
import java.util.List;

/*服务层操作*/
public class StudentService {
    StudentDao dao = new StudentDao();
    public int addStudent(Student stu){
        return dao.savaStudent(stu);
    }

    //分页条件查询业务
    public PageBean findPages(String currentPage,String pageSize,String name ,String sex){

        if (currentPage==null || currentPage.trim().equals("")){
            currentPage="1";
        }
        if (pageSize==null || pageSize.trim().equals("")){
            pageSize="3";
        }
        //创建一个PageBean
        PageBean pb = new PageBean();
        int cpage = Integer.parseInt(currentPage);
        int size = Integer.parseInt(pageSize);

        pb.setCurrentPage(cpage);
        pb.setPageSize(size);

        //初始化sql
        StringBuilder sb = new StringBuilder("select * from student where 1=1");

        //创建一个集合存放？占位符所需要的参数
        ArrayList<Object> params = new ArrayList<>();

        //["%小%，"男",0,3]

        if (name!=null && !name.trim().equals("")){
            sb.append("   and  name  like ?   ");
            params.add("%" + name + "%");
        }

        if (sex!=null && !sex.trim().equals("")){
            sb.append("   and  sex =  ?   ");
            params.add(sex);
        }

        //求总条数
        int totalCount = dao.findByCount(sb.toString(), params.toArray());
        pb.setTotalCount(totalCount);

        //计算总页数 总条数%每页显示条数==0?总条数/每页显示条数：总条数/每页显示条数+1;
        int totalPage = totalCount % size ==0 ? totalCount / size : totalCount / size +1;
        pb.setTotalPage(totalPage);

        sb.append("   limit ?,? ");

        //计算起始页码(当前页-1)*每条显示条数
        int start = (cpage-1)*size;

        params.add(start);
        params.add(size);
        //查询用户想看的数据
        List<Student> list = dao.findByLimit(sb.toString(),params.toArray());
        pb.setList(list);
        return pb;

    }
    //批量删除业务
    public int deleteSids(String sids){
        return  dao.deletBySids(sids);
    }
    //回显学生业务
    public Student findSudent(String sid){
       return dao.findStudentBySid(sid);
    }

    //更新业务
    public int updateStu(Student stu){
        return dao.updateStudentBySid(stu);
    }

}
