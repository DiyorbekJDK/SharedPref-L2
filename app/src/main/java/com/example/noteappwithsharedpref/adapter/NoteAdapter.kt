package com.example.noteappwithsharedpref.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.noteappwithsharedpref.R
import com.example.noteappwithsharedpref.model.Note

class NoteAdapter(private val context: Context, val list: ArrayList<Note>) : BaseAdapter {
    private val layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int = list.size

    override fun getItem(p0: Int): Any = list[p0]

    override fun getItemId(p0: Int): Long = p0.toLong()

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view: View = layoutInflater.inflate(R.layout.item_layout, p2, false)
        val title: TextView = view.findViewById(R.id.title_text)
        val time: TextView = view.findViewById(R.id.text_time)
        val note = getItem(p0) as Note
        title.text = note.title
        time.text = note.time
        return view

    }
    fun saveNote(note: Note){
        list.add(note)
        notifyDataSetChanged()
    }
}