package com.kay.accessappexercise.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public final class UserResponse {

    @Expose
    @SerializedName("login")
    private String login;

    @Expose
    @SerializedName("id")
    private String id;

    @Expose
    @SerializedName("avatar_url")
    private String avatarUrl;

    @Expose
    @SerializedName("site_admin")
    private boolean siteAdmin;

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public boolean isSiteAdmin() {
        return siteAdmin;
    }
}
