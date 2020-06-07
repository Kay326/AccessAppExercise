package com.kay.accessappexercise.ui.users;

import androidx.databinding.ObservableField;

import com.kay.accessappexercise.data.model.UserResponse;

public class UserItemViewModel {

    public final ObservableField<String> imageUrl;

    public final ObservableField<String> login;

    public final ObservableField<Boolean> sideAdmin;

    public UserItemViewModel(UserResponse user) {
        imageUrl = new ObservableField<>(user.getAvatarUrl());
        login = new ObservableField<>(user.getLogin());
        sideAdmin = new ObservableField<>(user.isSiteAdmin());
    }

}
