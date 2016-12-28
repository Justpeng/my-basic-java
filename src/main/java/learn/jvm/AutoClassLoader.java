package learn.jvm;

import java.io.*;

/**
 * @author:Just
 * @create:2016-12-24 15:20
 */
public class AutoClassLoader extends ClassLoader {

    private static String FILEPATH ;
    private byte[] loadClassData(String filePath) throws Exception {
        int n = 0;
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(new File(filePath)));
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((n = br.read()) != -1) {
            bos.write(n);
        }
        br.close();
        return bos.toByteArray();
    }

    public static String FormatClassName(String name) {
        FILEPATH = name + ".class";
        return FILEPATH;
    }

    public Class<?> findClass(String name) {
        byte b[] = null;
        try {
            b = loadClassData(FormatClassName(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return defineClass(name, b, 0, b.length);
    }
}
