package com.xuptdata.bdll.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: ningyq
 * @Date: 2019/5/13 16:01
 */
public class FtpUtil {

    /**
     * 获取IP地址
     */
    private static final String FTP_ADDRESS = "47.94.213.70";

    /**
     * 端口号
     */
    private static final String FTP_PORT = "21";

    /**
     * 用户名
     */
    private static final String FTP_USERNAME = "image";

    /**
     * 密码
     */
    private static final String FTP_PASSWORD = "xuptdata";

    /**
     * 基本路径，用户图片
     */
    private static final String FTP_BASE_PATH = "/www/wwwroot/image.xuptdata.com";

    private static final Log logger = LogFactory.getLog(FtpUtil.class);
    public static String pictureUploadByConfig(String pictureNewName, String pictureSavePath,
                                               InputStream inputStream) {
        logger.info("【pictureUploadByConfig】");
        String pictureHttpPath = null;

        boolean flag = uploadFile(pictureSavePath, pictureNewName, inputStream);

        System.out.println(flag);
        if (!flag) {
            return pictureHttpPath;
        }
        pictureHttpPath = pictureSavePath + "/" + pictureNewName;
        logger.info("【pictureHttpPath】" + pictureHttpPath);
        return pictureHttpPath;
    }

    /**
     * Description: 向FTP服务器上传文件
     *
     * FTP服务器文件存放路径
     * @param filePath
     * 上传到FTP服务器上的文件名
     * @param filename
     * 输入流
     * @param inputStream
     *
     * @return 成功返回true，否则返回false
     */
    private static boolean uploadFile(String filePath, String filename, InputStream inputStream) {
        int port = Integer.parseInt(FTP_PORT);
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            // 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.connect(FTP_ADDRESS, port);
            // 登录
            ftp.login(FTP_USERNAME, FTP_PASSWORD);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
//            System.out.println(FTP_BASE_PATH + filePath);
//            ftp.makeDirectory(filePath);
//            ftp.changeWorkingDirectory(filePath);
            // 切换到上传目录
            if (!ftp.changeWorkingDirectory(filePath)) {
                // 如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) {
                        continue;
                    }
                    if (!ftp.changeWorkingDirectory(dir)) {
                        if (ftp.makeDirectory(dir)) {
                            ftp.changeWorkingDirectory(dir);
                        } else {
                            return result;
                        }
                    }
                }
            }
            // 设置上传文件的类型为二进制类型
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            // 这个设置允许被动连接--访问远程ftp时需要
            ftp.enterLocalPassiveMode();
            // 上传文件
            if (!ftp.storeFile(filename, inputStream)) {
                return result;
            }
            inputStream.close();
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}