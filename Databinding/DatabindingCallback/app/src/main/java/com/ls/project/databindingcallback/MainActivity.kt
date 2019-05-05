package com.ls.project.databindingcallback

import android.databinding.*
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.SimpleAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var observableField: ObservableField<String> = ObservableField()
    var observableArrayList: ObservableArrayList<String> = ObservableArrayList()
    var observableArrayMap: ObservableArrayMap<String, Boolean> = ObservableArrayMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()

        observableField.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                sender as ObservableField<String>
                tv_field.text = sender.get()
            }
        })

        observableArrayList.addOnListChangedCallback(object :
            ObservableList.OnListChangedCallback<ObservableList<String>>() {
            override fun onChanged(sender: ObservableList<String>?) {
                val mutableList = sender?.toMutableList()
                val adapter = ArrayAdapter(baseContext, android.R.layout.simple_list_item_1, mutableList)
                listView_arrayList.adapter = adapter
                Toast.makeText(baseContext, "Changed ArrayList", Toast.LENGTH_SHORT).show()
            }

            override fun onItemRangeRemoved(sender: ObservableList<String>?, positionStart: Int, itemCount: Int) {
                val mutableList = sender?.toMutableList()
                val adapter = ArrayAdapter(baseContext, android.R.layout.simple_list_item_1, mutableList)
                listView_arrayList.adapter = adapter
                Toast.makeText(baseContext, "ItemRangeRemoved ArrayList", Toast.LENGTH_SHORT).show()
            }

            override fun onItemRangeMoved(
                sender: ObservableList<String>?,
                fromPosition: Int,
                toPosition: Int,
                itemCount: Int
            ) {
                val mutableList = sender?.toMutableList()
                val adapter = ArrayAdapter(baseContext, android.R.layout.simple_list_item_1, mutableList)
                listView_arrayList.adapter = adapter
                Toast.makeText(baseContext, "ItemRangeMoved ArrayList", Toast.LENGTH_SHORT).show()
            }

            override fun onItemRangeInserted(sender: ObservableList<String>?, positionStart: Int, itemCount: Int) {
                val mutableList = sender?.toMutableList()
                val adapter = ArrayAdapter(baseContext, android.R.layout.simple_list_item_1, mutableList)
                listView_arrayList.adapter = adapter
                Toast.makeText(baseContext, "ItemRangeInserted ArrayList", Toast.LENGTH_SHORT).show()
            }

            override fun onItemRangeChanged(sender: ObservableList<String>?, positionStart: Int, itemCount: Int) {
                val mutableList = sender?.toMutableList()
                val adapter = ArrayAdapter(baseContext, android.R.layout.simple_list_item_1, mutableList)
                listView_arrayList.adapter = adapter
                Toast.makeText(baseContext, "ItemRangeChanged ArrayList", Toast.LENGTH_SHORT).show()
            }
        })

        observableArrayMap.addOnMapChangedCallback(object :
            ObservableMap.OnMapChangedCallback<ObservableMap<String, Boolean>, String, Boolean>() {
            override fun onMapChanged(sender: ObservableMap<String, Boolean>?, key: String?) {
                val mapList = ArrayList<HashMap<String, String>>()
                sender?.forEach {
                    val inputData = HashMap<String, String>()
                    inputData["string"] = it.key
                    inputData["boolean"] = it.value.toString()
                    mapList.add(inputData)
                }
                val adapter = SimpleAdapter(baseContext, mapList, android.R.layout.simple_list_item_2, arrayOf("string", "boolean"),
                    intArrayOf(android.R.id.text1, android.R.id.text2)
                )
                listView_arrayMap.adapter=adapter
            }
        })
    }

    private fun initListener() {
        et_field.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                observableField.set(s.toString())
            }
        })

        btn_add_listItem.setOnClickListener {
            observableArrayList.add(et_array_list.text.toString())
        }
        btn_remove.setOnClickListener {
            if (observableArrayList.size > 0)
                observableArrayList.removeAt(0)
        }
        btn_reverse.setOnClickListener {
            observableArrayList.reverse()
        }
        btn_add_mapItem.setOnClickListener {
            val checkedRadioBtn = findViewById<View>(radioGroup.checkedRadioButtonId) as RadioButton
            observableArrayMap[et_array_map.text.toString()] = checkedRadioBtn.text == "True"
        }
        btn_clear.setOnClickListener {
            observableArrayList.clear()
        }
    }
}
