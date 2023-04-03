package com.example.example.ui.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.example.R
import com.example.example.database.Task
import com.example.example.databinding.FragmentAddBinding
import com.example.example.ui.task.TaskFragment
import com.example.example.viewmodel.TaskViewModel

class AddFragment : Fragment() {

    private val viewModel:TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = FragmentAddBinding.inflate(inflater)
        val myAdapter =ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
                    resources.getStringArray(R.array.priorties)
        )
        binding.apply {
            spinner.adapter=myAdapter
            btnADD.setOnClickListener {
                if (TextUtils.isEmpty((etTask.text))){
                        Toast.makeText(requireContext(),"is empty",Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                }
                var title_str=etTask.text.toString()
                val priority=spinner.selectedItemPosition
                var task =Task(
                    null,
                    title_str,
                    priority,
                    System.currentTimeMillis()
                )
                viewModel.insert(task)
                Toast.makeText(requireContext(),"Successfully  dd!",Toast.LENGTH_SHORT).show()
                val fragment = TaskFragment()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.container,fragment)?.commit()
            }

        }

        // Inflate the layout for this fragment
        return binding.root
    }


}