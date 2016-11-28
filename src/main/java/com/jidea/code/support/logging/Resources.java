package com.jidea.code.support.logging;

/**
 * 加载类
 *
 * @author:Just
 * @create:2016-11-12 9:13
 */
public final class Resources extends Object{
    public  static ClassLoader defaultClassLoader;
    private Resources(){

    }

    /**
     * Returns the default classLoader ,may be null
     * @return the default ClassLoader
     */
    public static ClassLoader getDefaultClassLoader() {
        return defaultClassLoader;
    }

    /**
     * Sets the default ClassLoader
     * @param classLoader
     */
    public static void setDefaultClassLoader(ClassLoader classLoader) {
        Resources.defaultClassLoader = classLoader;
    }

    public static Class<?> classForName (String className) throws ClassNotFoundException {
        Class<?> clazz = null;
        try{
            clazz = getClassLoader().loadClass(className);
        }catch (Exception e){
            // Ignore.
        }
        if (clazz != null) {
            clazz  = Class.forName(className);
        }
        return  clazz;
    }


    public static ClassLoader getClassLoader() {
        if(defaultClassLoader!=null){
            return  defaultClassLoader;
        }else{
            return Thread.currentThread().getContextClassLoader();
        }
    }
}
