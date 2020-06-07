package com.kay.accessappexercise.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kay.accessappexercise.data.AppDataManager;
import com.kay.accessappexercise.data.DataManager;
import com.kay.accessappexercise.data.remote.ApiHelper;
import com.kay.accessappexercise.data.remote.AppApiHelper;
import com.kay.accessappexercise.utils.rx.AppSchedulerProvider;
import com.kay.accessappexercise.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }
}
