package com.kay.accessappexercise.data;

import com.kay.accessappexercise.constants.ApiConstants;
import com.kay.accessappexercise.data.model.UserRequest;
import com.kay.accessappexercise.data.model.UserResponse;
import com.kay.accessappexercise.data.remote.ApiHelper;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager {

    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(ApiHelper apiHelper) {
        mApiHelper = apiHelper;
    }

    @Override
    public Single<List<UserResponse>> getUserListApiCall(UserRequest request) {
        return mApiHelper.getUserListApiCall(request);
    }
}
