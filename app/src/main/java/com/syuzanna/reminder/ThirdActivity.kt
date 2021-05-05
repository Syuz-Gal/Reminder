package com.syuzanna.reminder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.syuzanna.reminder.databinding.ActivityMainBinding
import com.syuzanna.reminder.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recyclerView = binding.recycler
        val items = mutableListOf<RowModel>(RowModel("Hi, my name is Syuzanna", "20/10/2029"))

        val adap = RecyclerViewAdapter(this, items)
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adap
    }
}