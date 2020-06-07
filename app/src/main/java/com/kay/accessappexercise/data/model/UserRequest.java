package com.kay.accessappexercise.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class UserRequest {

    @Expose
    @SerializedName("per_page")
    private String perPage;

    public UserRequest(String perPage) {
        this.perPage = perPage;
    }
}
