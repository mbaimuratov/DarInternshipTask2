package com.example.darinternshiptask2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class StudentsAdapter(dataSet: ArrayList<Student>?) : RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>() {

    lateinit var mData: ArrayList<Student>

    init {
        if (dataSet != null) {
            mData = dataSet
        }
    }

    class StudentViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.tv_name)
        val surnameTextView: TextView = view.findViewById(R.id.tv_surname)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.nameTextView.text = mData[position].name
        holder.surnameTextView.text = mData[position].surname
    }

    override fun getItemCount() = mData.size
}