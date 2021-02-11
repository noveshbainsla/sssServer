package com.smartsystem.sss.common;

import java.util.List;

public class BusinessException extends Exception {
    private List<ValidationMessage> validationMessages;
    public BusinessException(String message) {
        super(message);
    }

    public List<ValidationMessage> getValidationMessages() {
        return validationMessages;
    }

    public void setValidationMessages(List<ValidationMessage> validationMessages) {
        this.validationMessages = validationMessages;
    }
}
