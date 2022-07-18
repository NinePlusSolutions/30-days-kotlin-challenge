package com.example.navigationdrawer

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.LocaleList
import android.os.Message
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.TableLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.DialogTitle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var tempArrayList : ArrayList<News>
    private lateinit var newRecyclerview: RecyclerView
    private lateinit var newArrayList: ArrayList<News>
    lateinit var nameId: ArrayList<String>
    lateinit var addressId: ArrayList<String>


    lateinit var heading: ArrayList<String>
    lateinit var timeId: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            it.isChecked = true
            when (it.itemId) {

                R.id.nav_home -> replaceFragment(Home(), it.title.toString())
                R.id.nav_message -> replaceFragment(message(), it.title.toString())
                R.id.nav_sync -> Toast.makeText(
                    applicationContext,
                    "click Sync",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_trash -> Toast.makeText(
                    applicationContext,
                    "click Trash",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_setting -> replaceFragment(Setting(), it.title.toString())
                R.id.nav_login -> Toast.makeText(
                    applicationContext,
                    "click Login",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.nav_rate_us -> Toast.makeText(
                    applicationContext,
                    "click Rate Us",
                    Toast.LENGTH_SHORT
                ).show()

            }
            true
        }
        //data RecyclerView

        heading = arrayListOf(
            "Build your first Android apps with the Kotlin programming language.",
            "Build your first Android apps with the Kotlin programming language.",
            "Build your first Android apps with the Kotlin programming language.",
            "Build your first Android apps with the Kotlin programming language.",
            "You got call missed call from Evan",
            "Offer From Mobile Legends",
            "The Hobbit(Film series)",
            "You got call missed call from Evan",
            "Offer From Mobile Legends",
            "The Hobbit(Film series)"

        )
        nameId = arrayListOf(
            "Jack",
            "Man",
            "Cong",
            "Khanh",
            "Phu",
            "Duong",
            "Vu",
            "Thuan",
            "Linh",
            "Hai",
        )
        addressId = arrayListOf(
            "@VietNam",
            "@America",
            "@Laos",
            "@Cambodia",
            "@Canada",
            "@Punjab",
            "@California",
            "@Nathan",
            "@Haloing",
            "@newline",
        )
        timeId = arrayListOf(
            "5h ago",
            "2h ago",
            "Today",
            "Yesterday",
            "3h ago",
            "7h ago",
            "2h ago",
            "9h ago",
            "8h ago",
            "5h ago",
            )
        newRecyclerview = findViewById(R.id.recyclerView)
        newRecyclerview.layoutManager = LinearLayoutManager(this)
        newRecyclerview.setHasFixedSize(true)

        newArrayList = arrayListOf<News>()
        tempArrayList = arrayListOf<News>()
        getUserdata()
    }


    private fun replaceFragment(fragment: Fragment, title: String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu,menu)
        val item = menu?.findItem(R.id.search_name)
        val searchView = item?.actionView as androidx.appcompat.widget.SearchView
        searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false

            }

            override fun onQueryTextChange(newText: String?): Boolean {
                tempArrayList.clear()
                val searchText = newText!!.toLowerCase(Locale.getDefault())
                if (searchText.isNotEmpty()){
                    newArrayList.forEach {

                        if(it.heading.toLowerCase(Locale.getDefault()).contains(searchText)){
                            tempArrayList.add(it)
                        }

                    }
                    newRecyclerview.adapter!!.notifyDataSetChanged()
                }else{
                    tempArrayList.clear()
                    tempArrayList.addAll(newArrayList)
                    newRecyclerview.adapter!!.notifyDataSetChanged()

                }
                return false

            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    private fun getUserdata() {
        for (i in heading.indices) {
            val news = News(heading[i],nameId[i],addressId[i],timeId[i])
            newArrayList.add(news)

        }
        newRecyclerview.adapter = MyAdapter(newArrayList)
        tempArrayList.addAll(newArrayList)
    }


}