package com.example.example.ui.update

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.example.R
import com.example.example.database.Task
import com.example.example.databinding.FragmentUpdateBinding
import com.example.example.viewmodel.TaskViewModel


class UpdateFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUpdateBinding.inflate(inflater)
        binding.apply {
            btnUpdate.setOnClickListener {
                if (TextUtils.isEmpty((etupdateTask.text))){
                    Toast.makeText(requireContext(),"is empty", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val  tt=etupdateTask.text.toString()
                val priority =spinner.selectedItemPosition


            }
        }
        return binding.root
    }
}