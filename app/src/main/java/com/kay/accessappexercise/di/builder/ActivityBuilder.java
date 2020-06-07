package com.kay.accessappexercise.di.builder;

import com.kay.accessappexercise.ui.users.UsersActivity;
import com.kay.accessappexercise.ui.users.UsersActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = UsersActivityModule.class)
    abstract UsersActivity bindUsersActivity();

}
