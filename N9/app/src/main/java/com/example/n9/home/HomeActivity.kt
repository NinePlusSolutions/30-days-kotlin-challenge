package com.example.n9.home

    import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
    import androidx.fragment.app.Fragment
    import com.example.n9.R
    import com.example.n9.home.fragment.homepage.HomePageFragment
    import com.example.n9.home.fragment.notifications.NotificationsFragment
    import com.example.n9.home.fragment.search.SearchFragment
    import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        menu_bottom_nav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomePageFragment())
                R.id.search -> replaceFragment(SearchFragment())
                R.id.notifications -> replaceFragment(NotificationsFragment())
                else ->{

                }




            }
            true
        }

    }
    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.contentLayout, fragment)
        fragmentTransaction.commit()

    }

}