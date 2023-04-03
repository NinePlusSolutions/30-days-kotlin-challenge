package com.example.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.database.Entity
import com.example.todoapp.database.TaskDatabase
import com.example.todoapp.database.database
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)
        val pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            val title = database.getData(pos).title
            val priority = database.getData(pos).priority
            create_title.setText(title)
            create_priority.setText(priority)

            delete_button.setOnClickListener {
                database.deleteData(pos)
                GlobalScope.launch {
                    TaskDatabase.getDatabase(applicationContext).dao().deleteTask(
                        Entity(
                            pos + 1,
                            create_title.text.toString(),
                            create_priority.text.toString()
                        )
                    )
                }
                myIntent()
            }
            update_button.setOnClickListener {
                database.updateData(
                    pos, create_title.text.toString(),
                    create_priority.text.toString()
                )
                GlobalScope.launch {
                    TaskDatabase.getDatabase(applicationContext).dao().updateTask(
                        Entity(
                            pos + 1,
                            create_title.text.toString(),
                            create_priority.text.toString()
                        )
                    )
                }
                myIntent()
            }
        }
    }

    fun myIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}