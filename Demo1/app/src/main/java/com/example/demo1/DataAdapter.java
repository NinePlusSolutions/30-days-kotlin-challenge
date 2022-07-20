package com.example.demo1;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Data> mListData;
    private boolean isLoadingAdd;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_LOADING = 2;

    @SuppressLint("NotifyDataSetChanged")
    public void setData(List<Data> list) {
        this.mListData = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if (mListData != null && position == mListData.size() - 1 && isLoadingAdd) {
            return TYPE_LOADING;
        }
        return TYPE_ITEM;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (TYPE_ITEM == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user3, parent, false);
            return new DataViewHolder(view);

        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_loading, parent, false);
            return new LoadingViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_ITEM) {
            Data data = mListData.get(position);
            DataViewHolder dataViewHolder = (DataViewHolder) holder;
            dataViewHolder.imgAvatar.setImageResource(data.getResourceId());
            dataViewHolder.imgMessage1.setImageResource(data.getMessage1());
            dataViewHolder.imgFavorite.setImageResource(data.getFavorite());
            dataViewHolder.imgShare.setImageResource(data.getShare());
            dataViewHolder.tvName.setText(data.getName());
            dataViewHolder.tvCountry.setText(data.getCountry());
            dataViewHolder.tvTime.setText(data.getTime());
            dataViewHolder.tvComment.setText(data.getComment());
        }
    }

    @Override
    public int getItemCount() {
        if (mListData != null) {
            return mListData.size();
        }
        return 0;
    }

    public static class DataViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgAvatar;
        private final TextView tvName;
        private final TextView tvCountry;
        private final TextView tvTime;
        private final TextView tvComment;
        private final ImageView imgMessage1;
        private final ImageView imgFavorite;
        private final ImageView imgShare;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.ivAvt);
            imgMessage1 = itemView.findViewById(R.id.ivMessage);
            imgFavorite = itemView.findViewById(R.id.ivFavorite);
            imgShare = itemView.findViewById(R.id.ivShare);
            tvName = itemView.findViewById(R.id.tvName);
            tvCountry = itemView.findViewById(R.id.tvCountry);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvComment = itemView.findViewById(R.id.tvComment);
        }

    }

    public static class LoadingViewHolder extends RecyclerView.ViewHolder {

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void addFooterLoading() {
        isLoadingAdd = true;
    }

    public void removeFooterLoading() {
        isLoadingAdd = false;
        int position = mListData.size() - 1;
        Data data = mListData.get(position);
        if (data != null) {
            mListData.remove(position);
            notifyItemRemoved(position);
        }
    }


}
