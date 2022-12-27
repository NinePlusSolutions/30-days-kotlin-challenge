package com.example.tablayoutexample

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.tablayoutexample.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener

class MainActivity : AppCompatActivity() {
    private var adapter: PagerAdapter? = null
    private var tabLayout: TabLayout? = null
    private var viewPager2: ViewPager2? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager2 = findViewById<View>(R.id.viewpager) as ViewPager2
        tabLayout = findViewById<View>(R.id.tabs) as TabLayout

        tabLayout!!.addTab(tabLayout!!.newTab().setText("Hello"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("World"))

        adapter = PagerAdapter(supportFragmentManager, lifecycle)
        viewPager2!!.adapter = adapter

        tabLayout!!.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager2!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        viewPager2!!.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                tabLayout!!.selectTab(tabLayout!!.getTabAt(position))
            }
        })
    }
}