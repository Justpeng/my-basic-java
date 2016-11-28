package com.core.just.util;

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

}
