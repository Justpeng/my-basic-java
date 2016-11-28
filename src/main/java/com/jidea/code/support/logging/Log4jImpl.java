package com.jidea.code.support.logging;


import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author:Just
 *
 * log.error()
 * log.log()
 * @create:2016-11-12 10:33
 */
public class Log4jImpl implements Log {

    private static final String callerFQCN = Log4jImpl.class.getName();

    private Logger log;

    private int errorCount;
    private int infoCount;
    private int warnCount;
    private int debugCount;

    public Log4jImpl(Logger logger) {
        this.log = logger;
    }

    public Log4jImpl(String logName) {
        log = LogManager.getLogger(logName);
    }


    public Logger getLog() {
        return log;
    }

    public void setLog(Logger log) {
        this.log = log;
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public void error(String msg, Throwable e) {
        errorCount++;
        //log.error(msg);
        log.log(callerFQCN, Level.ERROR,msg,e);
    }

    @Override
    public void error(String msg) {
        errorCount++;
        log.log(callerFQCN,Level.ERROR,msg,null);
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    @Override
    public void info(String msg) {
        infoCount ++;
        log.log(callerFQCN,Level.INFO,msg,null);
    }

    @Override
    public void debug(String msg) {
        debugCount++;
        log.log(callerFQCN, Level.DEBUG, msg, null);
    }

    @Override
    public void debug(String msg, Throwable e) {
        debugCount++;
        log.log(callerFQCN,Level.DEBUG,msg,e);
    }

    @Override
    public boolean isWarnEnabled() {
        return log.isEnabledFor(Level.WARN);
    }

    @Override
    public void warn(String msg) {
        warnCount++;
        log.log(callerFQCN,Level.WARN,msg,null);
    }

    @Override
    public void warn(String msg, Throwable e) {
        warnCount++;
        log.log(callerFQCN,Level.WARN,msg,e);
    }

    @Override
    public boolean isErrorEnabled() {
        return log.isEnabledFor(Level.ERROR);
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
        debugCount=0;
        errorCount=0;
        errorCount=0;
        infoCount=0;
    }

}
