package com.example.iron.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadCsvUtil {


    public static String uploadCsv(String fileName,MultipartFile csvFile) throws IOException {
        //获取上传文件的文件名
        String oldName=csvFile.getOriginalFilename();
        //指定上传路径
        String path=new File("").getCanonicalPath()+"\\src\\main\\resources\\csvfile\\";
        //拼接成为新文件的路径
        String filePath=path+fileName+".csv";
        //创建新文件对象 指定文件路径为拼接好的路径
        File newFile=new File(filePath);
        //将前端传递过来的文件输送给新文件 这里需要抛出IO异常 throws IOException
        csvFile.transferTo(newFile);
        //上传完成后将文件路径返回给前端用作图片回显或增加时的文件路径值等
        return filePath;
    }
}
