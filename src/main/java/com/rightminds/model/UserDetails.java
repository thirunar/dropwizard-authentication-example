package com.rightminds.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetails {
    private long id;

    private String name;
    
    private String number;

    public UserDetails() {
    }

    public UserDetails(long id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @JsonProperty
    public String getNumber() {
        return number;
    }
}