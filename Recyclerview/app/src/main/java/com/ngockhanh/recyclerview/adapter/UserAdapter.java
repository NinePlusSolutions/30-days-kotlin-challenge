package com.ngockhanh.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ngockhanh.recyclerview.R;
import com.ngockhanh.recyclerview.inter.IClickItemUserListener;
import com.ngockhanh.recyclerview.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_LOADING = 2;
    private static List<User> mUserList;
    private boolean isLoadingAdd;
    private static IClickItemUserListener iClickItemUserListener;

    public UserAdapter(IClickItemUserListener iClickItemUserListener) {
        UserAdapter.iClickItemUserListener = iClickItemUserListener;
    }

    public void setData(List<User> mUserList) {
        UserAdapter.mUserList = mUserList;
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
        if (holder instanceof UserViewHolder) {
            ((UserViewHolder) holder).bind(holder);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List<Object> payloads) {
        if (holder instanceof UserViewHolder) {
            ((UserViewHolder) holder).bind(holder);
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
        private final ImageButton btnLike;
        private final ConstraintLayout layoutItem;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserName = itemView.findViewById(R.id.tvName);
            tvUserAddress = itemView.findViewById(R.id.tvAddress);
            tvUserTime = itemView.findViewById(R.id.tvTime);
            tvUserComment = itemView.findViewById(R.id.tvComment);
            btnLike = itemView.findViewById(R.id.btnLike);
            layoutItem = itemView.findViewById(R.id.layoutItem);
        }

        public void bind(final RecyclerView.ViewHolder holder) {
            if (holder.getItemViewType() == TYPE_ITEM) {
                User user = mUserList.get(holder.getAdapterPosition());
                UserViewHolder userViewHolder = (UserViewHolder) holder;
                userViewHolder.tvUserName.setText(user.getName());
                userViewHolder.tvUserComment.setText(user.getComment());
                userViewHolder.tvUserTime.setText(user.getTime());
                userViewHolder.tvUserAddress.setText(user.getAddress());
                userViewHolder.btnLike.setImageResource(
                        user.getLike() ? R.drawable.ic_baseline_favorite_24_red : R.drawable.ic_outline_favorite_border_24
                );
                userViewHolder.btnLike.setOnClickListener(view -> iClickItemUserListener.onLikedClickItemListener(user, holder.getAdapterPosition()));

                userViewHolder.layoutItem.setOnClickListener(view -> iClickItemUserListener.onClickItemUser(user));
            }
        }
    }

    public static class LoadingViewHolder extends RecyclerView.ViewHolder {

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            ProgressBar progressBar = itemView.findViewById(R.id.progressBar);
        }
    }

    public void addFooterLoading() {
        mUserList.add(new User("", "", "", "", false));
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
