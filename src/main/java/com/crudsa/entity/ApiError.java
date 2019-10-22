package com.crudsa.entity;

import java.util.Date;

public class ApiError {
    private Object apierror;
    private String status;
    private String timestamp;
    private String message;
    private String debugMessage;
    private SubErrors subErrors;

    public Object getApierror() {
        return apierror;
    }

    public void setApierror(Object apierror) {
        this.apierror = apierror;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public SubErrors getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(SubErrors subErrors) {
        this.subErrors = subErrors;
    }

    public ApiError(Object apierror, String status, String timestamp, String message, String debugMessage, SubErrors subErrors) {
        this.apierror = apierror;
        this.status = status;
        this.timestamp = timestamp;
        this.message = message;
        this.debugMessage = debugMessage;
        this.subErrors = subErrors;
    }

    public ApiError() {
    }
    
    public ApiError(Boolean error, Exception ex) {
        Date fecha = new Date();
        if (error) {
            this.apierror = ex;
            this.status ="Error";
            this.message = ex.getMessage();
            this.debugMessage = ex.getLocalizedMessage();
            this.timestamp = fecha+"";
        } else{
            this.apierror = null;
            this.status ="Success";
            this.message = null;
            this.debugMessage = null;
            this.timestamp = fecha+"";
        }
    }
}
