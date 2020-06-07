package com.kay.accessappexercise.di.component;

import android.app.Application;

import com.kay.accessappexercise.MvvmApp;
import com.kay.accessappexercise.di.builder.ActivityBuilder;
import com.kay.accessappexercise.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {

    void inject(MvvmApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
