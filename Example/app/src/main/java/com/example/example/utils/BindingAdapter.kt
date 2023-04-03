package com.example.example.utils

import android.graphics.Color
import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.DateFormat
import java.time.format.DateTimeFormatter

@BindingAdapter("setPriority")
fun setPriority(view:TextView,priority:Int){
    when(priority){
        0->{
            view.text="Hight priority"
            view.setTextColor(Color.RED)
        }
        1->{
            view.text="Medium priority"
            view.setTextColor(Color.BLUE)
        }
        else->{
            view.text="Low priority"
            view.setTextColor(Color.GREEN)
        }
    }
}

@BindingAdapter("setTimestamp")
fun setTime(view: TextView,timestamp:Long){
    view.text = DateFormat.getInstance().format(timestamp)
}

