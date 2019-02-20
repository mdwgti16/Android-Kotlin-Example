package com.ls.project.intentparcelable

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ls.project.intentparcelrable.model.Person

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var list = arrayListOf("치킨","피자","과일")
        val map = hashMapOf("1" to "A","2" to "B","3" to "C","4" to "D")
        var person = Person("KKK",15,list,map)
        val intent = Intent(this,IntentActivity::class.java)
        intent.putExtra("person",person)
        startActivity(intent)
    }
}
