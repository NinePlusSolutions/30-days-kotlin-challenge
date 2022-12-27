package com.example.recycleview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val mStudents: List<*>, private val mContext: Context) :
    RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        return if (viewType == 2) {
            StudentViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.student_item1, parent, false)
            )
        } else {
            StudentViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = mStudents[position] as Student
        holder.tv_studentName.text = student.getmName()
        holder.tv_birthYear.setText(student.birthYear.toString())
    }

    override fun getItemCount(): Int {
        return mStudents.size
    }

    override fun getItemViewType(position: Int): Int {
        return if ((position + 1) % 3 * 2 == 0) {
            2
        } else 1
    }

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_studentName: TextView
        var tv_birthYear: TextView
        var btn_detailStudent: Button

        init {
            tv_studentName = itemView.findViewById(R.id.tvStudentName)
            tv_birthYear = itemView.findViewById(R.id.tv_birthYear)
            btn_detailStudent = itemView.findViewById(R.id.btnDetail)
            // Xử lý khi nút chi tiết được bấm.
            btn_detailStudent.setOnClickListener { view ->
                Toast.makeText(
                    view.context,
                    tv_studentName.text.toString() + " | " + "Demo function",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}