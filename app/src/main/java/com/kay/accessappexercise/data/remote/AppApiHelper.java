package com.kay.accessappexercise.data.remote;

import com.kay.accessappexercise.data.model.UserRequest;
import com.kay.accessappexercise.data.model.UserResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() { }

    @Override
    public Single<List<UserResponse>> getUserListApiCall(UserRequest request) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_USER_LIST)
                .addQueryParameter(request)
                .build()
                .getObjectListSingle(UserResponse.class);
    }
}
