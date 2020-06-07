package com.kay.accessappexercise.ui.users;

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

    private final MutableLiveData<List<UserResponse>> userListLiveData;

    public UsersViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        userListLiveData = new MutableLiveData<>();
        fetchUsers();
    }

    public void fetchUsers() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getUserListApiCall(new UserRequest(ApiConstants.PER_PAGE))
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(userResponse -> {
                    if (userResponse != null) {
                        userListLiveData.setValue(userResponse);
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                }));
    }

    public LiveData<List<UserResponse>> getUserListLiveData() {
        return userListLiveData;
    }
}
