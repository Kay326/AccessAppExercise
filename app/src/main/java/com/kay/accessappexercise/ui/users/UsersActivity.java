package com.kay.accessappexercise.ui.users;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kay.accessappexercise.BR;
import com.kay.accessappexercise.R;
import com.kay.accessappexercise.ViewModelProviderFactory;
import com.kay.accessappexercise.data.model.UserResponse;
import com.kay.accessappexercise.databinding.ActivityUsersBinding;
import com.kay.accessappexercise.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class UsersActivity extends BaseActivity<ActivityUsersBinding, UsersViewModel> implements UsersNavigator {

    @Inject
    UsersAdapter mUsersAdapter;
    @Inject
    ViewModelProviderFactory mFactory;
    @Inject
    LinearLayoutManager mLayoutManager;
    private UsersViewModel mUsersViewModel;
    private ActivityUsersBinding mActivityUsersBinding;

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_users;
    }

    @Override
    public UsersViewModel getViewModel() {
        mUsersViewModel = ViewModelProviders.of(this, mFactory).get(UsersViewModel.class);
        return mUsersViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUsersViewModel.setNavigator(this);
        mActivityUsersBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        mActivityUsersBinding.recyclerView.setLayoutManager(mLayoutManager);
        mActivityUsersBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        mActivityUsersBinding.recyclerView.setAdapter(mUsersAdapter);
    }

    @Override
    public void updateUsers(List<UserResponse> userList) {
        mUsersAdapter.addItems(userList);
    }
}
