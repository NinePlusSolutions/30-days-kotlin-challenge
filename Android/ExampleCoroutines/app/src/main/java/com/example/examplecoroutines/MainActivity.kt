package com.example.examplecoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import com.example.examplecoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {
    private var count: Int = 1
    private var binding: ActivityMainBinding? = null

    suspend fun performTask(taskNumber: Number) : Deferred<String> {
        return CoroutineScope(Dispatchers.Main).async {
            delay(1_0000)
            return@async "Finish Coroutines ${taskNumber}"
        }
    }


    fun launchCoroutines(view: View){
        (1..count).forEach{
            binding?.tvStatus?.text = "Start Coroutines ${it}"
            CoroutineScope(Dispatchers.Main).launch {
                binding?.tvStatus?.text = performTask(it).await()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding?.seekBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                count = p1
                binding?.tvCount?.text = "${count} Corountine"

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }
        })
    }
}