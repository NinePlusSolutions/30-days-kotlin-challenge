package com.example.demo1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private List<Data> mListData;

    public DataAdapter(List<Data> mListData) {
        this.mListData = mListData;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user3,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Data data = mListData.get(position);
        holder.imgRepeat.setImageResource(data.getRepeat());
        if (data == null){
            return;
        }
        holder.imgAvatar.setImageResource(data.getResourceId());
        holder.imgMessage1.setImageResource(data.getMessage1());
        holder.imgFavorite.setImageResource(data.getFavorite());
        holder.imgShare.setImageResource(data.getShare());
        holder.tvName.setText(data.getName());
        holder.tvCountry.setText(data.getCountry());
        holder.tvTime.setText(data.getTime());
        holder.tvComment.setText(data.getComment());

    }

    @Override
    public int getItemCount() {
        if (mListData != null){
            return mListData.size();
        }
        return 0;
    }

    public class DataViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgAvatar;
        private TextView tvName;
        private TextView tvCountry;
        private TextView tvTime;
        private TextView tvComment;
        private ImageView imgMessage1;
        private ImageView imgRepeat;
        private ImageView imgFavorite;
        private ImageView imgShare;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.img_avt);
            imgMessage1 = itemView.findViewById(R.id.img_message);
            imgRepeat = itemView.findViewById(R.id.img_repeat);
            imgFavorite = itemView.findViewById(R.id.img_favorite);
            imgShare = itemView.findViewById(R.id.img_share);
            tvName = itemView.findViewById(R.id.tv_name);
            tvCountry = itemView.findViewById(R.id.tv_country);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvComment = itemView.findViewById(R.id.tv_commnet);
        }
    }
    public class LoadingViewHolder extends RecyclerView.ViewHolder{
        private ProgressBar progressBar;

        public LoadingViewHolder(@NonNull View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.process_bar);
        }
    }


}
