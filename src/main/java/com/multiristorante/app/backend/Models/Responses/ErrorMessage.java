package com.multiristorante.app.backend.Models.responses;

import java.util.Date;

public class ErrorMessage {

    private Date timestamp;
    private String message;

    public Date getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(Date timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    public ErrorMessage() {

    }

}
