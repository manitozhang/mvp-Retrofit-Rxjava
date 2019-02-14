package com.resource.util;

import android.os.AsyncTask;
import android.os.Environment;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;

/**
 * Author: 张
 * Email: 1271396448@qq.com
 * Date 2018/11/12
 *
 * 文件工具类
 */

public class FileUtil {


    private static URL url;

    /**
     * 判断文件是否存在
     * @param fileName
     * @return
     */
    public static boolean isFileExist(String fileName){
        File file = new File(BitmapUtil.getSDPath() + fileName);
        return file.exists();
    }

    public static InputStream getInputStearmFormUrl(String urlStr) throws IOException {
        url = new URL(urlStr);
        HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
        InputStream input = urlConn.getInputStream();
        return input;
    }
    public static File createDir(String dirName){
        File dir = new File(BitmapUtil.getSDPath() + dirName);
        dir.mkdir();
        return dir;
    }

    public static File createSDFile(String fileName) throws IOException {
        File file = new File(BitmapUtil.getSDPath() + fileName);
        file.createNewFile();
        return file;
    }


    public static File write2SDFromInput(String path, String fileName, InputStream input){
        File file = null;
        OutputStream output = null;

        try {
            createDir(path);
            file =createSDFile(path + fileName);
            output = new FileOutputStream(file);
            byte [] buffer = new byte[4 * 1024];
            while(input.read(buffer) != -1){
                output.write(buffer);
                output.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static int downlaodFile(String urlStr, String path, String fileName) {
        InputStream input = null;
        try {
            if (isFileExist(path + fileName)) {
                return 1;
            } else {
                input = getInputStearmFormUrl(urlStr);
                File resultFile = write2SDFromInput(path,fileName,input);
                if (resultFile == null)
                    return -1;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return  0;
    }

}
