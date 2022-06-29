package com.example.clickitemrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHoder>{

    public UserAdapter(List<User> mListUser) {

        this.mListUser = mListUser;
    }

    private List<User> mListUser;


    @NonNull
    @Override
    public UserViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHoder holder, int position) {
        User user=mListUser.get(position);
        if (user == null) {

            return;
        }
        holder.imgAvatar.setImageResource(user.getResourceId());
        holder.tvAddress.setText(user.getName());
        holder.tvName.setText(user.getName());

    }

    @Override
    public int getItemCount() {
        if(mListUser!=null){
            return mListUser.size();
        }
        return 0;
    }

    public class UserViewHoder extends RecyclerView.ViewHolder{

        private ImageView imgAvatar;
        private TextView tvName;
        private TextView tvAddress;


        public UserViewHoder(@NonNull View itemView) {
            super(itemView);
            imgAvatar=itemView.findViewById(R.id.img_avatar);
            tvName=itemView.findViewById(R.id.tv_name);
            tvAddress=itemView.findViewById(R.id.tv_address);


        }
    }
}
