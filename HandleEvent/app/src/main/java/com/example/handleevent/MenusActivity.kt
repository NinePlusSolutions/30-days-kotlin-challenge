package com.example.handleevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MenusActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menus)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true

    }

    //xử lý sự kiện với item được chọn
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.mnuHome->Toast.makeText(this,"Home page",Toast.LENGTH_SHORT).show()
            R.id.mnuSta->Toast.makeText(this,"chart page",Toast.LENGTH_SHORT).show()
            R.id.mnuSetting->Toast.makeText(this,"Setting page",Toast.LENGTH_SHORT).show()
        }
            return super.onOptionsItemSelected(item)
    }
}