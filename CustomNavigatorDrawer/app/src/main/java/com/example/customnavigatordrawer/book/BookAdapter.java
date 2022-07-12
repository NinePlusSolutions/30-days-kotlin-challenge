package com.example.customnavigatordrawer.book;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.customnavigatordrawer.R;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{
    private List<Book> mBooks;

    public  void setData(List<Book> list){
        this.mBooks=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book=mBooks.get(position);
        if (mBooks==null){
            return;
        }
        holder.imgBoook.setImageResource(book.getResourceId());
        holder.tvTitle.setText(book.getTitle());

    }

    @Override
    public int getItemCount() {
        if (mBooks!=null){
            return mBooks.size();
        }
        return 0;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgBoook;
        public TextView tvTitle;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);


            imgBoook=itemView.findViewById(R.id.img_book);
            tvTitle=itemView.findViewById(R.id.tv_title);
        }
    }
}
