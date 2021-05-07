package com.syuzanna.reminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.syuzanna.reminder.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        GlobalScope.launch(Dispatchers.IO) {
//            val userDao = UserDb.getInstance(this@MainActivity).userDao()
//            userDao.addUser(UserModel(0, "Hy", "20/10/23","11:23"))
//        }

        binding.addBtn.setOnClickListener(){
           val intent = Intent(this, SecondActivity::class.java)
          startActivity(intent)
//            GlobalScope.launch(Dispatchers.IO) {
//                val user = UserDb.getInstance(this@MainActivity).userDao().getAllUsers()
//
//                if (!user.isEmpty()) {
//                    withContext(Dispatchers.Main) {
//                       // binding.textTxt.setText("")
//                        binding.textTxt.setText(user.get(0).note)
//                    }
//                }
//            }
        }

        binding.notesBtn.setOnClickListener(){
            val intent = Intent(this, ThirdActivity::class.java)

            startActivity(intent)

        }
    }
}