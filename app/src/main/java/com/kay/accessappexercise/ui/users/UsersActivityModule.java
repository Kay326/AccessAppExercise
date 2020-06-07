package com.kay.accessappexercise.ui.users;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class UsersActivityModule {

    @Provides
    UsersAdapter provideUsersAdapter() {
        return new UsersAdapter(new ArrayList<>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(UsersActivity activity) {
        return new LinearLayoutManager(activity, RecyclerView.VERTICAL, false);
    }

}
