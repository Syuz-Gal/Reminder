package com.syuzanna.reminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.syuzanna.reminder.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val date = intent.getStringExtra(KEY_DATE)

        binding.addBtn.setOnClickListener(){
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        binding.notesBtn.setOnClickListener(){
            val intent = Intent(this, ThirdActivity::class.java)
            date?.let{
                intent.putExtra(KEY_DATE, date)
            }
            startActivity(intent)

        }
    }
}