package com.kay.accessappexercise.ui.users;

import com.kay.accessappexercise.data.model.UserResponse;

import java.util.List;

public interface UsersNavigator {

    void updateUsers(List<UserResponse> userList);
}
