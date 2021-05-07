package com.syuzanna.reminder

import android.app.DatePickerDialog
import android.app.PendingIntent.getActivity
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.syuzanna.reminder.databinding.ActivitySecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.math.min

class SecondActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
     var day = 0
     var month = 0
     var year = 0
     var hour = 0
     var minute = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0
    var savedHour = 0
    var savedMinute = 0

    lateinit var edit:EditText
    lateinit var btn:Button
    lateinit var date_txt: String
    lateinit var time_txt:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        edit = binding.edit
        btn = binding.datePicker

        pickData()
    }

    private fun getDateAndTimeCalendar(){
        val cal:Calendar =  Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)
        hour = cal.get(Calendar.HOUR)
        minute = cal.get(Calendar.MINUTE)
    }

    private fun pickData(){
        btn.setOnClickListener(){
            getDateAndTimeCalendar()
            DatePickerDialog(this,this, year, month, day).show()
        }
    }
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay = dayOfMonth
        savedMonth = month
        savedYear = year

        getDateAndTimeCalendar()
        TimePickerDialog(this, this, hour, minute, true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour = hourOfDay
        savedMinute = minute

        date_txt = "$savedDay/${savedMonth+1}/$savedYear"
        time_txt = "$savedHour:$savedMinute"
        GlobalScope.launch(Dispatchers.IO) {
            val userDao = UserDb.getInstance(this@SecondActivity).userDao()
          userDao.addUser(UserModel(0, edit.text.toString(), date_txt,time_txt))
            }
        }
    }
