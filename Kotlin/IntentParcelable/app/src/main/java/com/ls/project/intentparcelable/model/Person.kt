package com.ls.project.intentparcelrable.model

import android.os.Parcel
import android.os.Parcelable

class Person : Parcelable {
    var name: String? = null
    var age: Int = 0
    var favoriteFoodList: ArrayList<String> = ArrayList()
    var map: HashMap<String, Boolean> = HashMap()

    constructor(name: String, age: Int, favoriteFoodList: ArrayList<String>, map: HashMap<String, Boolean>) {
        this.name = name
        this.age = age
        this.favoriteFoodList = favoriteFoodList
        this.map = map
    }

    constructor(src: Parcel) {
        this.name = src.readString()
        this.age = src.readInt()
        src.readStringList(favoriteFoodList)
        this.map = buildTheMap(src)
    }

    fun buildTheMap(parcel: Parcel): HashMap<String, Boolean> {
        val size = parcel.readInt()
        val map = HashMap<String, Boolean>()

        for (i in 1..size) {
            val key = parcel.readString()
            val value = parcel.readInt() == 1
            map[key] = value
        }
        return map
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(age)
        dest.writeStringList(favoriteFoodList)

        dest.writeInt(map.size)
        for ((key, value) in map) {
            dest.writeString(key)
            dest.writeInt(if (value) 1 else 0)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Person> = object : Parcelable.Creator<Person> {
            override fun createFromParcel(src: Parcel): Person {
                return Person(src)
            }

            override fun newArray(size: Int): Array<Person?> {
                return arrayOfNulls(size)
            }
        }
    }
}