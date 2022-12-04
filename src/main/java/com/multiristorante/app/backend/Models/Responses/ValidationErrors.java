package com.multiristorante.app.backend.Models.Responses;

import java.util.Map;
import java.util.Date;

public class ValidationErrors {

    private Map<String, String> errors;
    private Date timestamp;

    public ValidationErrors(Map<String, String> errors, Date timestamp) {
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public Map<String, String> getErrors() {
        return this.errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
