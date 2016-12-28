package com.core.just.util;

import com.just.module.user.pojo.SysUser;

import java.util.Arrays;

/**
 * @author:Just
 * @create:2016-11-12 7:47
 */
public class StringUtils {

    /**
     * <p>Checks if a CharSequence is empty ("") or null</p>
     * @param src the CharSequence to check ,may be null
     * @return @Code true if the CharSequence is not empty and not null
     */
    public static boolean isEmpty(final CharSequence src){
        return src==null||src.length()==0;
    }
    public static boolean isNotEmpty(final CharSequence src){
        return !isEmpty(src);
    }



    public static void main(String args[]){
        String a = "123";
        String b = "123";
        String c = new String("123");

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(c));
        System.out.println(a.equals(b));




    }
}
