package com.jidea.code.support.logging;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 日志工厂类
 *
 * @author:Just
 * @create:2016-11-12 9:05
 */
public class LogFactory {
    public static Constructor logConstructor;

    static {

        String logType= System.getProperty("jidea.logType");
        if(logType != null){
            if(logType.equalsIgnoreCase("slf4j")){
                tryImplementation("org.slf4j.Logger", "com.jidea.code.support.logging.SLF4JImpl");
            }else if(logType.equalsIgnoreCase("log4j")){
                tryImplementation("org.apache.log4j.Logger", "com.jidea.code.support.logging.Log4jImpl");
            }else if(logType.equalsIgnoreCase("commonsLog")){
                tryImplementation("org.apache.commons.logging.LogFactory",
                        "com.jidea.code.support.logging.CommonsLoggingImpl");
            }else if(logType.equalsIgnoreCase("jdkLog")){
                tryImplementation("java.util.logging.Logger", "com.jidea.code.support.logging.JdkLoggingImpl");
            }
        }
        // 优先选择log4j,而非Apache Common Logging. 因为后者无法设置真实Log调用者的信息
        tryImplementation("org.apache.log4j.Logger", "com.jidea.code.support.logging.Log4jImpl");
        tryImplementation("org.slf4j.Logger", "com.jidea.code.support.logging.SLF4JImpl");
        tryImplementation("org.apache.commons.logging.LogFactory",
                "com.jidea.code.support.logging.CommonsLoggingImpl");
        tryImplementation("java.util.logging.Logger", "com.jidea.code.support.logging.JdkLoggingImpl");

        if (logConstructor == null) {
            try {
                logConstructor = NoLoggingImpl.class.getConstructor(String.class);
            } catch (Exception e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }
    }

    public static Log getLog(Class clazz) {
        return  getLog(clazz.getName());
    }

    public static Log getLog(String loggerName) {
        try {
            return (Log) logConstructor.newInstance(loggerName);
        } catch (Throwable t) {
            throw  new RuntimeException("Error creating logger for logger '" + loggerName + "'.  Cause: " + t, t);
        }
    }


    public static void tryImplementation(String className,String implClassName){
        if(logConstructor!=null){
            return;
        }
        try {
            Resources.classForName(className);
            Class implClass = Resources.classForName(implClassName);
            logConstructor = implClass.getConstructor(new Class[]{String.class});
            Class<?> decareClass = logConstructor.getDeclaringClass();
            if(Log.class.isAssignableFrom(decareClass)){
                logConstructor = null;
            }
            try{
                if (null != logConstructor) {
                    logConstructor.newInstance(LogFactory.class.getName());
                }
            }catch (Throwable t){
                logConstructor = null;
            }


        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static synchronized void selectLog4JLogging() {
        try {
            Resources.classForName("org.apache.log4j.Logger");
            Class implClass = Resources.classForName("com.jidea.code.support.logging.Log4jImpl");
            logConstructor = implClass.getConstructor(new Class[] { String.class });
        } catch (Throwable t) {
            //ignore
        }
    }

    @SuppressWarnings("unchecked")
    public static synchronized void selectJavaLogging() {
        try {
            Resources.classForName("java.util.logging.Logger");
            Class implClass = Resources.classForName("com.jidea.code.support.logging.JdkLoggingImpl");
            logConstructor = implClass.getConstructor(new Class[] { String.class });
        } catch (Throwable t) {
            //ignore
        }
    }


}
