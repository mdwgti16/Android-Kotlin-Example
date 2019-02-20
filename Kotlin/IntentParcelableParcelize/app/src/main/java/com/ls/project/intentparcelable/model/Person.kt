package com.ls.project.intentparcelrable.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Person (var name: String? = null,
              var age: Int = 0,
              var favoriteFoodList: ArrayList<String> = ArrayList(),
              var map :HashMap<String,String> = HashMap()): Parcelable