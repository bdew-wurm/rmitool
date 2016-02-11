package com.wurmonline.shared.exceptions;

public class WurmException extends Exception
{
    private static final long serialVersionUID = 1268608703615765075L;
    
    public WurmException(final String message) {
        super(message);
    }
    
    public WurmException(final Throwable cause) {
        super(cause);
    }
    
    public WurmException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
