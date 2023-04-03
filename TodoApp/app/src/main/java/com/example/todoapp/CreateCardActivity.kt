package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.todoapp.database.Dao
import com.example.todoapp.database.Entity
import com.example.todoapp.database.TaskDatabase
import com.example.todoapp.database.database
import com.example.todoapp.databinding.ActivityCreateCardBinding
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btnAdd
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.android.synthetic.main.view.view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateCardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val binding: ActivityCreateCardBinding
        super.onCreate(savedInstanceState)
        binding =ActivityCreateCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnAdd.setOnClickListener {
            if (TextUtils.isEmpty((edtCreatTitle.text.toString()))){
                Toast.makeText(this,"is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

                var title = edtCreatTitle.text.toString()
                var priority = edtPriority.text.toString()
                database.setData(title, priority)
                GlobalScope.launch {
                   TaskDatabase.getDatabase(applicationContext).dao().insertTask(Entity(0,title,priority))
                }
                var intent =Intent(this,MainActivity::class.java)
                startActivity(intent)


        }
    }
}