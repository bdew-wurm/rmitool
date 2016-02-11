package com.wurmonline.shared.exceptions;

public class WurmServerException extends WurmException {
    private static final long serialVersionUID = 1268608703615765075L;

    public WurmServerException(final String message) {
        super(message);
    }

    public WurmServerException(final Throwable cause) {
        super(cause);
    }

    public WurmServerException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
