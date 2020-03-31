package com.bkunzhang.web_file;

import com.bkunzhang.web_file.util.DownloadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author bingkun_zhang
 * @date 2020/3/31
 */
@RequestMapping("/file")
@Controller
public class FileController {
    /**
     * 下载附件
     * @param path 附件路径
     * @param fileName  附件名称
     * @param response
     * eg: http://localhost:9998/file/download?path=https://cdn.jdy.com/mjdy/crm/haibao/img14.jpg&fileName=%E4%BD%A0%E5%A5%BD%E5%95%8A.jpg
     */
    @RequestMapping(value="/download", method= RequestMethod.GET)
    public void download(String path,String fileName, HttpServletResponse response){
        byte[] filebytes = DownloadUtil.getImageFromNetByUrl(path);
        if (filebytes == null){
            return;
        }
        try {
            fileName = new String(fileName.getBytes(), "ISO-8859-1");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return;
        }
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;fileName="+fileName);
        OutputStream os = null;
        try{
            os = response.getOutputStream();
            int length = filebytes.length;
            os.write(filebytes, 0, length);

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if (os != null){
                    os.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
