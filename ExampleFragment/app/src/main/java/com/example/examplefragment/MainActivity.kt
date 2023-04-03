package com.example.examplefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (savedInstanceState == null) {
//            supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                add(R.id.fragment_add)
//            }
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.add(R.id.container, AddFragment(), "Add").commitAllowingStateLoss()
    }

//    private fun removeFragment(){
//        val fragment =supportFragmentManager.findFragmentByTag("Add")
//        fragment?.let {
//            val trans = supportFragmentManager.beginTransaction()
//            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
//            trans.remove(it).commitAllowingStateLoss()
//        }
//    }
}