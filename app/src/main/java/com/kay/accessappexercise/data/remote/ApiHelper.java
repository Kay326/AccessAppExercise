package com.kay.accessappexercise.data.remote;

import com.kay.accessappexercise.data.model.UserRequest;
import com.kay.accessappexercise.data.model.UserResponse;

import java.util.List;

import io.reactivex.Single;

public interface ApiHelper {

    Single<List<UserResponse>> getUserListApiCall(UserRequest request);
}
