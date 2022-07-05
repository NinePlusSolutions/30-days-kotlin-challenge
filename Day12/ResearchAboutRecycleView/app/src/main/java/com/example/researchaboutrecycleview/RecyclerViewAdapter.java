package com.example.researchaboutrecycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<ItemDesignModel> userList;

    public RecyclerViewAdapter(List<ItemDesignModel>userList) {
        this.userList=userList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int resource = userList.get(position).getCardView1();
        String name = userList.get(position).getTv1();
        String description = userList.get(position).getTv2();


        holder.setData(resource, name, description);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgView;
        private TextView tv1;
        private TextView tv2;


        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imgView = itemView.findViewById(R.id.imgView1);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);

        }

        private void setData(int resource, String name, String description) {
            imgView.setImageResource(resource);
            tv1.setText(name);
            tv2.setText(description);
        }
    }
}
