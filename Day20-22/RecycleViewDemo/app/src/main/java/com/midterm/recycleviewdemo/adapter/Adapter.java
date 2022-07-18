package com.midterm.recycleviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.midterm.recycleviewdemo.R;
import com.midterm.recycleviewdemo.model.Comment;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 1;
    private static final int TYPE_LOADING = 0;
    private List<Comment> mCommentList;

    public Adapter(List<Comment> mCommentList) {
        this.mCommentList = mCommentList;
    }
    public void setData(List<Comment> mUserList) {
        this.mCommentList = mUserList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new CommentViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_load_more, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_ITEM) {
            Comment Comment = mCommentList.get(position);
            ((CommentViewHolder) holder).tvNameUser.setText(Comment.getnameUser());
            ((CommentViewHolder) holder).tvTagName.setText(Comment.gettagName());
            ((CommentViewHolder) holder).tvTime.setText(Comment.gettime());
            ((CommentViewHolder) holder).tvUserComment.setText(Comment.getcomment());
        }
    }

    @Override
    public int getItemCount() {
        if (mCommentList != null) {
            return mCommentList.size();
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return mCommentList.get(position) == null ? TYPE_LOADING : TYPE_ITEM;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvNameUser, tvTagName, tvTime, tvUserComment;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNameUser = itemView.findViewById(R.id.tv_user_name);
            tvTagName = itemView.findViewById(R.id.tv_user_tagname);
            tvTime = itemView.findViewById(R.id.tv_user_time);
            tvUserComment = itemView.findViewById(R.id.tv_user_comment);
        }
    }

    public class LoadingViewHolder extends RecyclerView.ViewHolder {
        private final ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.progressBar);
        }
    }
}
