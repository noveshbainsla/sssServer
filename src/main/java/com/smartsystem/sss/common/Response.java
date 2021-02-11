package com.smartsystem.sss.common;

import java.io.Serializable;
import java.util.List;

public class Response implements Serializable {
    private boolean success;
    private String message;
    private List<ValidationMessage> ValidationMessages;
    private List<Object> responseObjects;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<ValidationMessage> getValidationMessages() {
        return ValidationMessages;
    }

    public void setValidationMessages(List<ValidationMessage> validationMessages) {
        ValidationMessages = validationMessages;
    }

    public List<Object> getResponseObjects() {
        return responseObjects;
    }

    public void setResponseObjects(List<Object> responseObjects) {
        this.responseObjects = responseObjects;
    }
}
