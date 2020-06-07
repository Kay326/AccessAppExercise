package com.kay.accessappexercise.ui.users;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.kay.accessappexercise.data.model.UserResponse;
import com.kay.accessappexercise.databinding.ItemUserBinding;
import com.kay.accessappexercise.ui.base.BaseViewHolder;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<UserResponse> mUserResponseList;

    public UsersAdapter(List<UserResponse> blogResponseList) {
        this.mUserResponseList = blogResponseList;
    }

    @Override
    public int getItemCount() {
        if (mUserResponseList != null && mUserResponseList.size() > 0) {
            return mUserResponseList.size();
        } else {
            return 0;
        }
    }

    public void addItems(List<UserResponse> userList) {
        mUserResponseList.addAll(userList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mUserResponseList.clear();
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserBinding viewBinding = ItemUserBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new UserViewHolder(viewBinding);
    }

    public class UserViewHolder extends BaseViewHolder {

        private ItemUserBinding mBinding;

        UserViewHolder(ItemUserBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final UserResponse user = mUserResponseList.get(position);
            UserItemViewModel mUserItemViewModel = new UserItemViewModel(user);
            mBinding.setViewModel(mUserItemViewModel);
            mBinding.executePendingBindings();
        }
    }
}