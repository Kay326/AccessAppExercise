package com.kay.accessappexercise;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.androidnetworking.AndroidNetworking;
import com.kay.accessappexercise.di.component.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class MvvmApp extends Application implements HasActivityInjector {

    private static final String TAG = MvvmApp.class.getSimpleName();

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    private static Context mContext;

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        MvvmApp.mContext = getApplicationContext();

        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);

        AndroidNetworking.enableLogging();
    }

    public static Context getAppContext() {
        return MvvmApp.mContext;
    }
}
