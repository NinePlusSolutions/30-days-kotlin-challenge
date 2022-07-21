package com.example.test_duration_4h

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.test_duration_4h.databinding.UserCommentBinding

class PageAdapter : BaseRecyclerViewAdapter<UserModel, PageAdapter.ItemViewHolder>() {

    class ItemViewHolder(
        private val viewBinding: UserCommentBinding
    ) : RecyclerView.ViewHolder(viewBinding.root) {
        fun onBindView(item: UserModel?) {
            with(viewBinding) {
                tvUsername.text = item?.username
                tvLocation.text = item?.location
                tvTime.text = item?.time
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            UserCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBindView(getItem(position))
    }
}
