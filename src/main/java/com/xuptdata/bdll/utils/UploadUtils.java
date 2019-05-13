package com.xuptdata.bdll.utils;

import java.io.File;
import java.util.UUID;

/**
 * @Author: ningyq
 * @Date: 2019/5/13 16:00
 */
public class UploadUtils {

    /**
     * 得到真实文件名
     * @param fileName
     * @return
     */
    public static String subFileName(String fileName) {
        // 查找最后一个 \ (文件分隔符)位置
        int index = fileName.lastIndexOf(File.separator);
        if (index == -1) {
            // 没有分隔符，说明是真实名称
            return fileName;
        } else {
            return fileName.substring(index + 1);
        }
    }

    /**
     * 获得随机UUID文件名
     *
     * @param fileName
     * @return
     */
    public static String generateRandomFileName(String fileName) {
        // 首相获得扩展名，然后生成一个UUID码作为名称，然后加上扩展名
        String ext = fileName.substring(fileName.lastIndexOf("."));
        return UUID.randomUUID().toString() + ext;
    }

    public static String generateRandomFileName() {
        return UUID.randomUUID().toString();
    }
}
