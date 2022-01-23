package com.infinira.sms.util;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.infinira.sms.util.I18N;
import com.infinira.sms.util.SMSException;

public class Util {    
    private static Util instance;
    private Logger logger;  
   
    private Util() {
        logger = LogManager.getLogger(Util.class);
    }
    
    public static Util getInstance() {
        // To ensure only one instance is created
        if (instance == null) {
            synchronized (Util.class) {
                if (instance == null) {
                    instance = new Util();
                }
            }
        }
        return instance;
    }
    
    public Logger getLogger() {
        return logger;
    }
   
    // To prepare SMSException
    public static SMSException prepareException(String key, Throwable th, Object ...args) {
        String message = I18N.getInstance().getMessage(key, args);
        getInstance().getLogger().error(message, th);
        return new SMSException(message, th);
    } 
}