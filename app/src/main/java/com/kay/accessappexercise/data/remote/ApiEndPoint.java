package com.kay.accessappexercise.data.remote;

import com.kay.accessappexercise.BuildConfig;

public final class ApiEndPoint {

    public static final String ENDPOINT_USER_LIST = BuildConfig.BASE_URL + "/users";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }
}
