package com.kay.accessappexercise.ui.users;

import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kay.accessappexercise.constants.ApiConstants;
import com.kay.accessappexercise.data.DataManager;
import com.kay.accessappexercise.data.model.UserRequest;
import com.kay.accessappexercise.data.model.UserResponse;
import com.kay.accessappexercise.ui.base.BaseViewModel;
import com.kay.accessappexercise.utils.rx.SchedulerProvider;

import java.util.List;

public class UsersViewModel extends BaseViewModel<UsersNavigator> {

    private final MutableLiveData<List<UserResponse>> mUserListLiveData;
    private final ObservableBoolean mShowRetry;

    public UsersViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        mUserListLiveData = new MutableLiveData<>();
        mShowRetry = new ObservableBoolean();
        mShowRetry.set(true);
        fetchUsers();
    }

    private void fetchUsers() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getUserListApiCall(new UserRequest(ApiConstants.PER_PAGE))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(userResponse -> {
                    if (userResponse != null) {
                        mUserListLiveData.setValue(userResponse);
                    }

                    mShowRetry.set(true);
                    setIsLoading(false);
                }, throwable -> {
                    mShowRetry.set(false);
                    setIsLoading(false);
                }));
    }

    public void onRetryClick() {
        mShowRetry.set(true);
        fetchUsers();
    }

    public LiveData<List<UserResponse>> getUserListLiveData() {
        return mUserListLiveData;
    }

    public ObservableBoolean getShowRetry() {
        return mShowRetry;
    }
}
