package com.example.restapi.dtos;

import com.google.gson.annotations.Expose;

public class AuthorSeenDto {
    @Expose
    private String name;

    public AuthorSeenDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
