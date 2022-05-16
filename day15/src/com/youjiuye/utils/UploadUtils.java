package com.youjiuye.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/*上传文件工具类*/
public class UploadUtils {
    /*
    *   String:重命名后的文件名
    *       request:上传文件要用到的对象
    *
    *
    * */
    public static String upload(HttpServletRequest request) {
        try {
            //1.根据文件名获取文件资源
            Part part = request.getPart("photo");
            //2.从文件资源中获取文件名 pgone.jpg
            String fileName = part.getSubmittedFileName();
            //3.重命名文件名 asdas-fdsf21-dsad0-21daspgone.jpg
            fileName= UUID.randomUUID()+fileName;
            //4.组装写入地址
            File file = new File("d:/upload");
            if (!file.exists()){
                //如果文件夹不存在
                file.mkdir();//创建文件夹
            }
            // d:/upload/asdas-fdsf21-dsad0-21daspgone.jpg
            String path = file + "/" + fileName;
            //5.将文件写入该路径
            part.write(path);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        return null;
    }
}
