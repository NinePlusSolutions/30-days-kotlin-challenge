package com.example.example.ui.task

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.example.database.Task
import com.example.example.databinding.RowLayoutBinding


class TaskAdapter(val clickListener: TaskClick) : ListAdapter <Task,TaskAdapter.ViewHolder>(TaskDiffCallBack){
    class ViewHolder (val binding: RowLayoutBinding): RecyclerView.ViewHolder(binding.root){
            fun bind(task: Task,clickListener: TaskClick){
                binding.taskEntry=task
                binding.clickListener = clickListener
                binding.executePendingBindings()
            }
    }

    companion object TaskDiffCallBack : DiffUtil.ItemCallback<Task>(){

        override fun areItemsTheSame(oldItem: Task, newItem: Task) = oldItem.id == newItem.id


        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Task, newItem: Task) = oldItem == newItem

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(RowLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current,clickListener)
    }
}

class TaskClick(val clickListener:(taskEntry:Task)->Unit){
    fun onCLick(taskEntry: Task) = clickListener(taskEntry)
}