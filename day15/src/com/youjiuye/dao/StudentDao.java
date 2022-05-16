package com.youjiuye.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.youjiuye.entity.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/*数据库操作*/
public class StudentDao {
    ComboPooledDataSource dataSource =new ComboPooledDataSource();
    QueryRunner qr = new QueryRunner(dataSource);

    public int savaStudent(Student stu){
        String sql = "insert into student values(null,?,?,?,?,?,?)";

        try {
            return qr.update(sql,stu.getName(),stu.getSex(),stu.getHobby(),stu.getBirthday()
            ,stu.getSdesc(),stu.getPhoto());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public int findByCount(String sql,Object[]toArray){
        List<Student> studentList=null;
        try {
            studentList= qr.query(sql, new BeanListHandler<Student>(Student.class), toArray);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList.size();
    }

    public List<Student> findByLimit(String sql,Object[] toArray){
        try {
            return qr.query(sql,new BeanListHandler<Student>(Student.class),toArray);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int deletBySids(String sids){
        String sql = "delete from student where sid in("+sids+")";
        try {
           return qr.update(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Student findStudentBySid(String sid){
        String sql = "select * from student where sid=?";
        try {
            return  qr.query(sql,new BeanHandler<Student>(Student.class),sid);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public int updateStudentBySid(Student stu){
        String sql = "update student set name=?,sex=?,hobby=?,birthday=?,sdesc=?,photo=? where sid=?";
        try {
            return qr.update(sql,stu.getName(),stu.getSex(),stu.getHobby()
                ,stu.getBirthday(),stu.getSdesc(),stu.getPhoto(),stu.getSid());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
