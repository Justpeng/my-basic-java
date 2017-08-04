package com.core.just.util;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * Description:
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 08/03/2017-22:17
 */
@Slf4j
public class FileUtil {

    /**
     * 文件分割的方法（方法内传入要分割的文件路径以及要分割的份数）
     * @param src
     * @param m
     */
    public static void splitFile(File src, int m) {
        if (src==null || !src.isFile()) {
            log.error("文件为空！");
            return;
        }

        //获取文件的总长度
        long l = src.length();
        //获取文件名
        String fileName = src.getName().substring(0, src.getName().indexOf("."));
        //获取文件后缀
        String endName = src.getName().substring(src.getName().lastIndexOf("."));
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(src);
            for(int i = 1; i <= m; i++) {
                StringBuffer sb = new StringBuffer();
                sb.append(src.getParent()).append("\\").append(fileName).append("_data").append(i).append(endName);
                System.out.println(sb.toString());
                File file2 = new File(sb.toString());
                //创建写文件的输出流
                out = new FileOutputStream(file2);
                int len;
                byte[] bytes = new byte[10*1024*1024];
                while((len = in.read(bytes))!=-1) {
                    out.write(bytes, 0, len);
                    if(file2.length() > (l / m)) {
                        break;
                    }
                }
                out.close();
            }
        } catch (Exception e) {
            log.error("split异常",e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                log.error("split异常",e);
            }
        }
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\TCLDUSER\\Desktop\\daoke-download-2017-08-03(1)\\log\\tracer.20170803-20.log";
        File file = new File(path);

        splitFile(null,30);
    }
}
