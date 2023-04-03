package com.example.example.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import com.example.example.R
import com.example.example.databinding.FragmentTaskBinding
import com.example.example.ui.add.AddFragment
import com.example.example.viewmodel.TaskViewModel


class TaskFragment : Fragment() {
    private val viewModel:TaskViewModel by viewModels()
    private lateinit var adapter:TaskAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val  binding = FragmentTaskBinding.inflate(inflater)
        binding.lifecycleOwner=this
        binding.viewModle=viewModel
        adapter = TaskAdapter(TaskClick { taskEntry ->
        })
        viewModel.getAll.observe(viewLifecycleOwner){
            adapter.submitList(it) //cập nhật dữ liệu hiện thị lên giao diện người dungg dựa trên sự thay đổi
                                    //của dữ liệu trong ViewModle bằng observe
                                    //observe để quan sát các thay đổi trong 1 live data
        }
        binding.apply {
            binding.rcvTask.adapter = adapter
            btnAdd.setOnClickListener {
                val fragment = AddFragment()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.container,fragment)?.commit()
            }
        }
        // Inflate the layout for this fragment
        return binding.root
    }


}


