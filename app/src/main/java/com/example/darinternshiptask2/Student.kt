package com.example.darinternshiptask2

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(val name: String = "", val surname: String = "") : Parcelable