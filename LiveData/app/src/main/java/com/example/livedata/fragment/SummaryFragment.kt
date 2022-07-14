package com.example.livedata.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.MedalViewModel
import com.example.livedata.R
import kotlinx.android.synthetic.main.fragment_summary.*

class SummaryFragment : Fragment() {
    lateinit var mMedalViewModel: MedalViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mMedalViewModel = ViewModelProvider(this)[MedalViewModel::class.java]

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_summary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mMedalViewModel.numberOfGoldMedal.observe(requireActivity(),Observer<Int>{ displaySumMedal() } )
        mMedalViewModel.numberOfSilverMedal.observe(requireActivity(), Observer<Int> { displaySumMedal() })
        mMedalViewModel.numberOfBronzeMedal.observe(requireActivity(), Observer<Int> { displaySumMedal() })
        displaySumMedal()
    }

    private fun displaySumMedal() {
        var totalMedal: Int = mMedalViewModel?.numberOfGoldMedal?.value!!.plus(mMedalViewModel?.numberOfSilverMedal?.value!!).plus(mMedalViewModel?.numberOfBronzeMedal?.value!!)
        tvNumberOfMedal.text = totalMedal.toString()
    }
}