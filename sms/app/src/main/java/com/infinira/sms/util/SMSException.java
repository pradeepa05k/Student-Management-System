package com.infinira.sms.util;

/**
* The SMSException wraps all unchecked exception in SMS App and enriches them with a custom error message.
*/

public class SMSException extends RuntimeException {    
    public SMSException(String message, Throwable cause) {
        super(message, cause);
    }   
    
    public SMSException(String message) {
        super(message);
    }       
}