package learn.arithmetic;


import com.core.just.util.StringUtils;
import com.sun.org.apache.xml.internal.utils.StringBufferPool;

/**
 * @author:Just
 * @create:2016-11-12 7:44
 */
public class SomeDemo {

    /**
     * 判断一个词是否是回文
     * #使用
     * @param str
     * @return
     */
    public static boolean checkPaindrom(String str){
        if(StringUtils.isEmpty(str)){
            return false;
        }
        StringBuffer sr = new StringBuffer(str);
        return str.equals(sr.reverse().toString());
    }
    public static void main(String args[]){
        System.out.println(checkPaindrom("aa11aa"));
    }


}
