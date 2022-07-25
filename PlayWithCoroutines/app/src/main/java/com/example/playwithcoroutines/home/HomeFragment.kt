package com.example.playwithcoroutines.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.playwithcoroutines.R

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        rootView.findViewById<Button>(R.id.btnStart).setOnClickListener {
            homeViewModel.start()
        }

        rootView.findViewById<Button>(R.id.btnStop).setOnClickListener{
            homeViewModel.stop()
        }


        return rootView
    }

}