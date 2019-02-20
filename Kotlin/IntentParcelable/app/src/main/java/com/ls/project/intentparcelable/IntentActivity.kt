package com.ls.project.intentparcelable

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.SimpleAdapter
import com.ls.project.intentparcelrable.model.Person
import kotlinx.android.synthetic.main.activity_intent.*

class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        val person = intent.getParcelableExtra<Person>("person")
        name.text=person.name
        age.text=person.age.toString()

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,person.favoriteFoodList)
        listView.adapter=adapter

        var list = mutableListOf<HashMap<String,String>>()
        for(i in person.map){
            var hashMap = HashMap<String,String>()
            hashMap["id"]=i.key
            hashMap["password"]=i.value.toString()
            list.add(hashMap)
        }
        val mapAdapter = SimpleAdapter(this,list,android.R.layout.simple_list_item_2,
            arrayOf("id","password"), intArrayOf(android.R.id.text1,android.R.id.text2))
        mapListView.adapter=mapAdapter
    }
}
