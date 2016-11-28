package com.jidea.code.support.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author:Just
 * @create:2016-11-12 11:30
 */
public class JdkLoggingImpl implements Log {
    private Logger log;
    private int    errorCount;
    private int    warnCount;
    private int    infoCount;
    private int    debugCount;

    private String loggerName;

    public JdkLoggingImpl(String loggerName) {
        this.loggerName = loggerName;
        log = Logger.getLogger(loggerName);
    }


    @Override
    public boolean isErrorEnabled() {
        return log.isLoggable(Level.SEVERE);
    }

    @Override
    public void error(String msg, Throwable e) {
        errorCount++;
        log.logp(Level.SEVERE,loggerName,Thread.currentThread().getStackTrace()[1].getMethodName(),msg,e);
    }

    @Override
    public void error(String msg) {
        errorCount++;
        log.logp(Level.SEVERE,loggerName,Thread.currentThread().getStackTrace()[1].getMethodName(),msg);
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isLoggable(Level.INFO);
    }

    @Override
    public void info(String msg) {
        infoCount++;
        log.logp(Level.INFO,loggerName,Thread.currentThread().getStackTrace()[1].getMethodName(),msg);
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isLoggable(Level.FINE);
    }

    @Override
    public void debug(String msg) {
        log.logp(Level.FINE,loggerName,Thread.currentThread().getStackTrace()[1].getMethodName(),msg);
    }

    @Override
    public void debug(String msg, Throwable e) {
        log.logp(Level.FINE,loggerName,Thread.currentThread().getStackTrace()[1].getMethodName(),msg,e);
    }

    @Override
    public boolean isWarnEnabled() {
        return log.isLoggable(Level.WARNING);
    }

    @Override
    public void warn(String msg) {
        log.logp(Level.WARNING,loggerName,Thread.currentThread().getStackTrace()[1].getMethodName(),msg);
    }

    @Override
    public void warn(String msg, Throwable e) {
        log.logp(Level.WARNING,loggerName,Thread.currentThread().getStackTrace()[1].getMethodName(),msg,e);
    }



    @Override
    public int getErrorCount() {
        return errorCount;
    }

    @Override
    public int getWarnCount() {
        return warnCount;
    }

    @Override
    public int getInfoCount() {
        return infoCount;
    }

    @Override
    public int getDebugCount() {
        return debugCount;
    }

    @Override
    public void resetStat() {
        infoCount=0;
        errorCount=0;
        warnCount=0;
        debugCount=0;
    }
}
