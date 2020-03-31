package com.bkunzhang.web_file.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author bingkun_zhang
 * @date 2020/3/31
 */
public class DownloadUtil {

    public static byte[] getImageFromNetByUrl(String requestUrl) {
        InputStream is = null;
        HttpURLConnection conn = null;
        try {
            URL url = new URL(requestUrl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            is = conn.getInputStream(); // 通过输入流获取图片数据
            byte[] byteImage = readInputStream(is); // 将流转成二进制数据
            return byteImage;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try{
                if (is != null){
                    is.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
            if (conn != null){
                conn.disconnect();
            }
        }
        return null;
    }

    private static byte[] readInputStream(InputStream is) {
        if (is == null){
            return new byte[0];
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        try {
            while ((len = is.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return baos.toByteArray();
    }
}
