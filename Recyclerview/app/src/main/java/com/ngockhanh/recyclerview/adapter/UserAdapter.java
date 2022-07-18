package com.ngockhanh.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ngockhanh.recyclerview.R;
import com.ngockhanh.recyclerview.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_LOADING = 2;
    private List<User> mUserList;
    private boolean isLoadingAdd;

    public void setData(List<User> mUserList) {
        this.mUserList = mUserList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (mUserList != null && position == mUserList.size() - 1 && isLoadingAdd) {
            return TYPE_LOADING;
        }
        return TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (TYPE_ITEM == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
            return new UserViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_ITEM) {
            User user = mUserList.get(position);
            UserViewHolder userViewHolder = (UserViewHolder) holder;
            userViewHolder.tvUserName.setText(user.getName());
            userViewHolder.tvUserComment.setText(user.getComment());
            userViewHolder.tvUserTime.setText(user.getTime());
            userViewHolder.tvUserAddress.setText(user.getAddress());
        }
    }

    @Override
    public int getItemCount() {
        if (mUserList != null) {
            return mUserList.size();
        }
        return 0;
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvUserName;
        private final TextView tvUserAddress;
        private final TextView tvUserTime;
        private final TextView tvUserComment;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tv_item_user_name);
            tvUserAddress = itemView.findViewById(R.id.tv_item_user_address);
            tvUserTime = itemView.findViewById(R.id.tv_item_user_time);
            tvUserComment = itemView.findViewById(R.id.tv_item_comment_content);
        }
    }

    public static class LoadingViewHolder extends RecyclerView.ViewHolder {
        private final ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }

    public void addFooterLoading() {
        mUserList.add(new User("", "", "", ""));
        isLoadingAdd = true;
    }

    public void removeFooterLoading() {
        isLoadingAdd = false;

        int position = mUserList.size() - 1;
        User user = mUserList.get(position);
        if (user != null) {
            mUserList.remove(position);
            notifyItemRemoved(position);
        }
    }
}
