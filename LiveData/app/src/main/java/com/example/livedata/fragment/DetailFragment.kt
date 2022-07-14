package com.example.livedata.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.MedalViewModel
import com.example.livedata.R
import kotlinx.android.synthetic.main.fragment_detail.*

class DetailFragment : Fragment() {
    lateinit var mMedalViewModel: MedalViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mMedalViewModel = ViewModelProvider(this).get(MedalViewModel::class.java)
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mMedalViewModel.numberOfGoldMedal.observe(requireActivity(), Observer<Int> { displayMedal() })
        mMedalViewModel.numberOfSilverMedal.observe(requireActivity(), Observer<Int> { displayMedal() })
        mMedalViewModel.numberOfBronzeMedal.observe(requireActivity(), Observer<Int> { displayMedal() })
    }

    @SuppressLint("StringFormatInvalid")
    private fun displayMedal() {
        tvDetailGoldNumber.text = activity?.getString(R.string.number_of_gold_label, mMedalViewModel?.numberOfGoldMedal?.value)
        tvDetailSilverNumber.text = activity?.getString(R.string.number_of_silver_label, mMedalViewModel?.numberOfSilverMedal?.value)
        tvDetailBronzeNumber.text = activity?.getString(R.string.number_of_bronze_label, mMedalViewModel?.numberOfBronzeMedal?.value)
    }
}
