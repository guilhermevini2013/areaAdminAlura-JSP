package org.example.areaadminalurajsp.exception;

import org.example.areaadminalurajsp.dtos.error.ErrorModel;

public class BadCredentialsException extends Exception{
    private ErrorModel errorModel;
    public BadCredentialsException(ErrorModel error) {
        this.errorModel = error;
    }

    @Override
    public String getMessage() {
        return errorModel.getError();
    }

    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }

    public ErrorModel getErrorModel() {
        return errorModel;
    }
}
