package com.jidea.code.support.logging;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author:Just
 * @create:2016-11-12 11:22
 */
public class CommonsLoggingImpl implements com.jidea.code.support.logging.Log {
    private Log log ;

    private int errorCount;
    private int warnCount;
    private int infoCount;
    private int debugCount;

    public CommonsLoggingImpl(Log log) {
        this.log = log;
    }

    public CommonsLoggingImpl(String loggerName) {
        log =  LogFactory.getLog(loggerName);
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public void error(String msg, Throwable e) {
        errorCount++;
        log.error(msg,e);
    }

    @Override
    public void error(String msg) {
        errorCount++;
        log.error(msg);
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    @Override
    public void info(String msg) {
        infoCount++;
        log.info(msg);
    }

    @Override
    public void debug(String msg) {
        debugCount++;
        log.debug(msg);
    }

    @Override
    public void debug(String msg, Throwable e) {
        debugCount++;
        log.debug(msg,e);
    }

    @Override
    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    @Override
    public void warn(String msg) {
        warnCount++;
        log.warn(msg);
    }

    @Override
    public void warn(String msg, Throwable e) {
        warnCount++;
        log.warn(msg,e);
    }

    @Override
    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
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
        warnCount=0;
        debugCount=0;
        errorCount=0;
    }
}
