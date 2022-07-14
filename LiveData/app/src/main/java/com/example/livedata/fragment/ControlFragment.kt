package com.example.livedata.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.livedata.MedalViewModel
import com.example.livedata.R
import kotlinx.android.synthetic.main.fragment_control.*


class ControlFragment : Fragment(), View.OnClickListener {
    lateinit var mMedalViewModel: MedalViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mMedalViewModel = ViewModelProvider(this)[MedalViewModel::class.java]
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_control, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayMedal()

        btnGoldMinus.setOnClickListener(this)
        btnGoldPlus.setOnClickListener(this)
        btnSilverMinus.setOnClickListener(this)
        btnSilverPlus.setOnClickListener(this)
        btnBronzeMinus.setOnClickListener(this)
        btnBronzePlus.setOnClickListener(this)

    }

    private fun displayMedal() {
        tvMainGoldNumber.text = mMedalViewModel.numberOfGoldMedal.value.toString()
        tvMainSilverNumber.text = mMedalViewModel.numberOfSilverMedal.value.toString()
        tvMainBronzeNumber.text = mMedalViewModel.numberOfBronzeMedal.value.toString()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            btnGoldMinus.id -> {
                mMedalViewModel.numberOfGoldMedal.value =
                    mMedalViewModel.numberOfGoldMedal.value?.minus(1)
                displayMedal()
            }
            btnGoldPlus.id -> {
                mMedalViewModel.numberOfGoldMedal.value =
                    mMedalViewModel.numberOfGoldMedal.value?.plus(1)
                displayMedal()
            }
            btnSilverMinus.id -> {
                mMedalViewModel.numberOfSilverMedal.value =
                    mMedalViewModel.numberOfSilverMedal.value?.minus(1)
                displayMedal()
            }
            btnSilverPlus.id -> {
                mMedalViewModel.numberOfSilverMedal.value =
                    mMedalViewModel.numberOfSilverMedal.value?.plus(1)
                displayMedal()
            }
            btnBronzeMinus.id -> {
                mMedalViewModel.numberOfBronzeMedal.value =
                    mMedalViewModel.numberOfBronzeMedal.value?.minus(1)
                displayMedal()
            }
            btnBronzePlus.id -> {
                mMedalViewModel.numberOfBronzeMedal.value =
                    mMedalViewModel.numberOfBronzeMedal.value?.plus(1)
                displayMedal()
            }
        }
    }
}