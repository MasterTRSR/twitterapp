package org.lithium.twitter.models;

public class ErrorObject {


    private String context;
    private String message;
    private String errorCode;

    public ErrorObject(String context, String message, String errorCode){
        this.context = context;
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
