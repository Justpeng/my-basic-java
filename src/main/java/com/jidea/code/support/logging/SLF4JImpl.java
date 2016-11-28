package com.jidea.code.support.logging;

import org.omg.CORBA.UNSUPPORTED_POLICY;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

/**
 * SLF4J
 *
 * @author:Just
 * @create:2016-11-12 10:56
 */
public class SLF4JImpl implements Log {
    private static final String callerFQCN = SLF4JImpl.class.getName();
    private static final Logger testLogger = LoggerFactory.getLogger(SLF4JImpl.class);
    static {
        //限制实现类
        if(!(testLogger instanceof LocationAwareLogger)){
            throw new UnsupportedOperationException(testLogger.getClass() + "is  not suitable logger");
        }
    }
    private LocationAwareLogger log;
    private int errorCount;
    private int infoCount;
    private int debugCount;
    private int warnCount;


    public SLF4JImpl(LocationAwareLogger logger) {
        this.log = logger;
    }

    public SLF4JImpl(String logName) {
        log = (LocationAwareLogger) LoggerFactory.getLogger(logName);
    }

    @Override
    public boolean isDebugEnabled() {
        return log.isDebugEnabled();
    }

    @Override
    public void error(String msg, Throwable e) {
        errorCount++;
        log.log(null,callerFQCN,LocationAwareLogger.ERROR_INT,msg,null,e);
    }

    @Override
    public void error(String msg) {
        errorCount++;
        log.log(null,callerFQCN,LocationAwareLogger.ERROR_INT,msg,null,null);
    }

    @Override
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }

    @Override
    public void info(String msg) {
        infoCount++;
        log.log(null,callerFQCN,LocationAwareLogger.INFO_INT,msg,null,null);
    }

    @Override
    public void debug(String msg) {
        debugCount++;
        log.log(null,callerFQCN,LocationAwareLogger.DEBUG_INT,msg,null,null);
    }

    @Override
    public void debug(String msg, Throwable e) {
        debugCount++;
        log.log(null,callerFQCN,LocationAwareLogger.DEBUG_INT,msg,null,e);
    }

    @Override
    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }

    @Override
    public void warn(String msg) {
        warnCount++;
        log.log(null,callerFQCN,LocationAwareLogger.WARN_INT,msg,null,null);
    }

    @Override
    public void warn(String msg, Throwable e) {
        warnCount++;
        log.log(null,callerFQCN,LocationAwareLogger.WARN_INT,msg,null,e);
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
        errorCount=0;
        warnCount=0;
        debugCount=0;
    }
}
