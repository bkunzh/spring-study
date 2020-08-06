package com.bkunzh.controller;

import com.bkunzhang.util.FileUtil;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;


/**
 * @author bkunzh
 * 文件下载工具，可以替代windows共享，windows共享在某些网络设置不对或者受限
 */
@RestController
public class FileController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);
    // 环境变量 download_file_dir
    private final static String fileDir = System.getenv("download_file_dir");
    private File countFile = new File(fileDir, "call_interface_count.txt");

    private volatile int count = 0;
    final static int MAX_COUNT = 60; // 60次
    long time = System.currentTimeMillis();

    // 结束进程
    @PostMapping("/service/close")
    public String closeService() {
        FileUtil.writeStrToFile(countFile, "0");
        log.info("系统停止运行，次数清0");
        System.exit(0);
        return "not return";
    }


    /**
     * 限制接口请求次数，超过一定次数就不让访问了
     */
//    @Async
    public void countCallInterface() {
        synchronized (FileController.class) {
            fileExists();
            // 1小时重置一次访问次数
//            if (System.currentTimeMillis() - time > 3600 * 1000) {
//                time = System.currentTimeMillis();
//                count = 0;
//                FileUtil.writeStrToFile(countFile, "0");
//            }
            String countStr = FileUtil.readFileAsStr(countFile);
            if (countStr == null || countStr.trim().isEmpty()) {
//                FileUtil.writeStrToFile(countFile, String.valueOf(count));
            } else {
                int count0 = Integer.valueOf(countStr);
//                count = Math.max(count0, count);
                count = count0;
            }
            ++count;
            FileUtil.writeStrToFile(countFile, String.valueOf(count));
        }
    }

    public void fileExists() {
        if (!countFile.exists()) {
            try {
                countFile.createNewFile();
                log.info("createNewFile " + countFile.getAbsolutePath());
            } catch (IOException e) {
                log.error("createNewFile ", e);
            }
        }
    }

    @GetMapping("/download/{fileName}")
    public String downloadFile(@PathVariable("fileName") String fileName, HttpServletResponse response) throws Exception {
        countCallInterface();
        if (count > MAX_COUNT) {
            log.warn("超过访问次数");
            System.out.println("超过访问次数");
            return null;
        }
        try {
            log.info("开始下载:" + fileName);

            if (fileName != null) {
                if (fileDir == null || "".equals(fileDir)) {
                    return "没有设置环境变量download_file_dir";
                }
                File file = new File(fileDir, fileName);
                if (file.exists()) {
                    FileInputStream fis = null;
                    BufferedInputStream bis = null;
                    try {
                        if (fileName.endsWith(".doc")) {
                            response.setContentType("application/msword");
                        } else if (fileName.endsWith(".docx")) {
                            // docx下载后，打开提示内容有问题，用poi的XWPFDocument解决，还是不行
                            log.info(".docx");
                            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                            fis = new FileInputStream(file);
                            XWPFDocument document = new XWPFDocument(OPCPackage.open(fis));
                            document.write(response.getOutputStream());
                            return "yes";
                        }else {
                            response.setContentType("application/octet-stream"); // 二进制，word如果设置这个会有问题
                        }
                        response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));// 设置文件名
                        byte[] buffer = new byte[1024];

                        fis = new FileInputStream(file);
                        bis = new BufferedInputStream(fis);
                        OutputStream os = response.getOutputStream();
                        int i = bis.read(buffer);
                        while (i != -1) {
                            os.write(buffer, 0, i);
                            i = bis.read(buffer);
                        }
                        os.flush();
                        return "下载成功";
                    } finally {
                        if (bis != null) {
                            try {
                                bis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fis != null) {
                            try {
                                fis.close();
                                log.info("fis close");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        } finally {
            log.info("下载完成或退出");
        }
        return "下载失败";
    }


}
