package com.monsanto.interview.FortuneCookieGenerator;

import java.util.UUID;

public class FortuneCookie {

    private String id;
    private String message;

    public FortuneCookie(String message) {
        this.id = UUID.randomUUID().toString();
        this.message = message;
    }
    //Created for json deserialisation 
    public FortuneCookie() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

