package com.syuzanna.reminder

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val context: Context, val items: MutableList<RowModel>): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.row_model, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val row_model = items.get(position)
        holder.noteTxt.text = row_model.note
        holder.dateTxt.text = row_model.date

    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var noteTxt: TextView
        var dateTxt: TextView
        var checkbox :CheckBox
        var button: Button

        init{
            noteTxt = view.findViewById(R.id.note_txt)
            dateTxt = view.findViewById(R.id.date)
            checkbox = view.findViewById(R.id.checkbox)
            button = view.findViewById(R.id.refactor)
        }
    }
}