package com.midterm.recycleviewdemo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.midterm.recycleviewdemo.R;
import com.midterm.recycleviewdemo.databinding.ItemBinding;
import com.midterm.recycleviewdemo.databinding.ItemLoadMoreBinding;
import com.midterm.recycleviewdemo.model.Comment;
import com.midterm.recycleviewdemo.inter.IClickItemCommentListener;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int typeItem = 1;
    private static final int typeLoading = 0;
    private List<Comment> commentList;
    private final IClickItemCommentListener iClickItemCommentListener;

    public RecycleViewAdapter(IClickItemCommentListener iClickItemCommentListener) {
        this.iClickItemCommentListener = iClickItemCommentListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == typeItem) return new CommentViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
        return new LoadingViewHolder(ItemLoadMoreBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == typeItem) {
            ((CommentViewHolder) holder).onBindingData(commentList.get(position));
        }
    }

    @Override
    public int getItemCount() { return commentList.size(); }

    @Override
    public int getItemViewType(int position) { return commentList.get(position) == null ? typeLoading : typeItem; }


    public void setData(List<Comment> commentList){
        this.commentList = commentList;
    }

    public class CommentViewHolder extends RecyclerView.ViewHolder {
        private final ItemBinding itemBinding;

        public CommentViewHolder(@NonNull ItemBinding inflate) {
            super(inflate.getRoot());
            this.itemBinding = inflate;
        }

        public void onBindingData(Comment comment) {
            this.itemBinding.tvUserName.setText(comment.getCommentUserName());
            this.itemBinding.tvUserName.setText(comment.getCommentUserTagName());
            this.itemBinding.tvCommentContent.setText(comment.getCommentTime());
            this.itemBinding.tvCommentContent.setText(comment.getCommentContent());
            this.itemBinding.ivLike.setImageResource(comment.getLike() ?R.drawable.ic_baseline_favorite_24:R.drawable.ic_baseline_favorite_border_24);
            this.itemBinding.ivLike.setOnClickListener(view -> {
                comment.setLike(!comment.getLike());
                this.itemBinding.ivLike.setImageResource(comment.getLike() ?R.drawable.ic_baseline_favorite_24:R.drawable.ic_baseline_favorite_border_24);
            });
            this.itemBinding.layoutItem.setOnClickListener(view -> iClickItemCommentListener.onClickItemComment(comment));
        }
    }

    public static class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(@NonNull ItemLoadMoreBinding itemLoadMoreBinding) {
            super(itemLoadMoreBinding.getRoot());
        }
    }
}
