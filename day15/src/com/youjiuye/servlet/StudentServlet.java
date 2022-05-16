package com.youjiuye.servlet;

import com.youjiuye.entity.Student;
import com.youjiuye.service.StudentService;
import com.youjiuye.utils.PageBean;
import com.youjiuye.utils.UploadUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/stu")
@MultipartConfig
public class StudentServlet extends BaseServlet{
   StudentService service =new StudentService();
   public void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException {
       //1.将数据接收到map中
       Map<String, String[]> map = request.getParameterMap();
       //2.创建学生对象
       Student stu = new Student();
       //3.将map中的数据封装到stu对象中
       BeanUtils.populate(stu,map);
       //接收爱好
       String[] hobbies = request.getParameterValues("hobby");
       stu.setHobby(Arrays.toString(hobbies));
       //4.文件上传
       String fileName = UploadUtils.upload(request);
       stu.setPhoto(fileName);
       //5.调用业务
       int row = service.addStudent(stu);
       if (row>0){
           System.out.println("添加成功");
       }else{
           System.out.println("添加学生失败");
       }
   }

   public void findPages(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       //1.接收分页参数
       String currentPage = request.getParameter("currentPage");
       String pageSize = request.getParameter("pageSize");
       //2接收查询参数
       String name = request.getParameter("name");
       String sex = request.getParameter("sex");
       //3.调用业务
       PageBean pb = service.findPages(currentPage, pageSize, name, sex);

       request.setAttribute("pb",pb);
       //转发到list.jsp展示学生页码
       request.getRequestDispatcher("/student/list.jsp").forward(request,response);
   }

   public void del(HttpServletRequest request,HttpServletResponse response) throws IOException {
       //1.接收参数
       String sids = request.getParameter("sids");
       //2.调用业务
       int row = service.deleteSids(sids);
       if(row>0){
           response.sendRedirect(request.getContextPath()+"/stu?method=findPages");
       }else{
           throw new RuntimeException("批量删除失败");
       }
   }

   public void findStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.接收sid
       String sid = request.getParameter("sid");
       //2.调用业务
       Student stu = service.findSudent(sid);
       //3.将学生对象放入request域对象
       request.setAttribute("stu",stu);
       //转发
       request.getRequestDispatcher("/student/edit.jsp").forward(request,response);
   }

   public void update(HttpServletRequest request,HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
       //1.获取表单的数据到map
       Map<String, String[]> map = request.getParameterMap();
       //2.创建学生对象
       Student stu = new Student();
       //3.将map中的数据封装到stu中
       BeanUtils.populate(stu,map);
       String[] hobbies = request.getParameterValues("hobby");
       stu.setHobby(Arrays.toString(hobbies));
       //stu:photo
       //根据文件名获取文件资源
       Part part = request.getPart("photo");
       //从文件资源中获取文件名
       String fileName = part.getSubmittedFileName();
       if(fileName==null || fileName.equals("")){
           //没有上传新图片
           //获取老的图片名称
           String oldPhoto = request.getParameter("oldPhoto");
           //设置一样的图片名称
           stu.setPhoto(oldPhoto);
       }else{
           //文件上传
           String newFileName = UploadUtils.upload(request);
           //设置新文件名
           stu.setPhoto(newFileName);
       }
       //调用业务
       int row = service.updateStu(stu);
       if (row>0){
           response.sendRedirect(request.getContextPath()+"/stu?method=findPages");
       }else{
           throw new RuntimeException("更新数据失败");
       }
   }

}
