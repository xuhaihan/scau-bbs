package com.scau.bbs.rest.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.time.LocalDate;
import java.util.UUID;

import static com.scau.bbs.rest.utils.Constants.*;

/** @Author xhh Create By 2019/2/1 */
public class FileUtils {

  public static String uploadFile(MultipartFile file) throws IOException {
    if (!file.isEmpty()) {
      String today = LocalDate.now().toString();
      String type = file.getContentType();
      String suffix = "." + type.split("/")[1];
      String userUploadPath = today + "/";
      String fileName = UUID.randomUUID().toString() + suffix;
      String realUploadPath =userUploadPath + fileName;
      if (uploadFile(realUploadPath, file.getInputStream())) {
           return Constants.STATIC_URL + userUploadPath + fileName;
      }
    }
    return null;
  }

  public static boolean uploadFile(String filename, InputStream input) {

    boolean result = false;
    FTPClient ftp = new FTPClient();
    try {
      String realFileName="";
      int reply;
      ftp.connect(Constants.FTP_ADDRESS, Constants.FTP_PORT); // 连接FTP服务器
      // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
      ftp.login(Constants.FTP_USERNAME, Constants.FTP_PASSWORD); // 登录
      reply = ftp.getReplyCode();
      if (!FTPReply.isPositiveCompletion(reply)) {
        ftp.disconnect();
        return result;
      }
      // 切换到上传目录
      if (!ftp.changeWorkingDirectory(filename)) {
        // 如果目录不存在创建目录
        String[] dirs = filename.split("/");
        String tempPath ="";
        realFileName=dirs[dirs.length-1];
        dirs[dirs.length-1]="";
        for (String dir : dirs) {
          if (null == dir || "".equals(dir)) continue;
          tempPath += "/" + dir;
          if (!ftp.changeWorkingDirectory(tempPath)) {
            if (!ftp.makeDirectory(tempPath)) {
              return result;
            } else {
              ftp.changeWorkingDirectory(tempPath);
            }
          }
        }
      }
      // 设置上传文件的类型为二进制类型
      ftp.enterLocalPassiveMode();
      ftp.setFileType(FTP.BINARY_FILE_TYPE);
      // 上传文件

      if (!ftp.storeFile(realFileName, input)) {
        return result;
      }
      input.close();
      ftp.logout();
      result = true;
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (ftp.isConnected()) {
        try {
          ftp.disconnect();
        } catch (IOException ioe) {
        }
      }
    }
    return result;
  }
}
