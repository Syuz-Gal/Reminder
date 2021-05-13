package com.syuzanna.reminder

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.syuzanna.reminder.databinding.ActivityMainBinding
import com.syuzanna.reminder.databinding.ActivityThirdBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ThirdActivity : AppCompatActivity() {
    lateinit var items: MutableList<RowModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recycler
        GlobalScope.launch(Dispatchers.IO) {
               val user = UserDb.getInstance(this@ThirdActivity).userDao().getAllUsers()

                if (!user.isEmpty()) {
                    withContext(Dispatchers.Main) {
                               items = mutableListOf(RowModel(user.get(0).note, user.get(0).date))
                                       for(i in 1 until user.size){
                                           items.add(i, RowModel(user.get(i).note, user.get(i).date))
                                       }


                        val adap = RecyclerViewAdapter(this@ThirdActivity, items)
                        recyclerView.layoutManager = LinearLayoutManager(this@ThirdActivity,
                                LinearLayoutManager.VERTICAL, false)
                        recyclerView.adapter = adap
                    }
                  }
            }

    }
}