package com.ls.project.areacard.viewmodel

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.ls.project.areacard.adapter.ListRecyclerViewAdapter
import com.ls.project.areacard.model.ListItem

class MainViewModel : ViewModel {
    lateinit var adapter: ListRecyclerViewAdapter
    private lateinit var items: ArrayList<ListItem>
    override fun onCreate() {
        items = arrayListOf<ListItem>()
        for (i in 0..10) {
            items.add(ListItem("구역 $i", "${i * 10}"))
        }
        adapter = ListRecyclerViewAdapter(items)
        /** 2 */
//        adapter.setOnItemClickListener(object : ListRecyclerViewAdapter.ClickListener{
//            override fun onItemClick(v: View, pos: Int) {
//                var linear = (v as LinearLayout)
//                var text = "${getChildText(linear,0)} ${getChildText(linear,1)} ${getChildText(linear,2)}"
//                Toast.makeText(linear.context,text,Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onItemLongClick(v: View, pos: Int) {
//                var linear = (v as LinearLayout)
//                var text = "${getChildText(linear,0)} ${getChildText(linear,1)} ${getChildText(linear,2)}"
//                Toast.makeText(linear.context,"$text Long",Toast.LENGTH_SHORT).show()
//            }
//        })

        /** 1 */
//        adapter.onClick = {
//            var text = "${getChildText(it, 0)} ${getChildText(it, 1)} ${getChildText(it, 2)}"
//            Toast.makeText(it.context, text, Toast.LENGTH_SHORT).show()
//        }

    }

    /** 1 */
//    private fun getChildText(view: View, pos: Int): String {
//        return ((view as LinearLayout).getChildAt(pos) as TextView).text.toString()
//    }

    override fun onDestroy() {
    }

    override fun onPause() {
    }

    override fun onResume() {
    }
}