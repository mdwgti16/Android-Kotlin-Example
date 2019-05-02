package com.ls.project.navigation


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavGraphNavigator
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import kotlinx.android.synthetic.main.fragment_second.*

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_second_activity.setOnClickListener {
//            findNavController().navigate(R.id.action_global_secondMain)
            val message = activity_message.text.toString()
            val action = MainFragmentDirections.actionMainFragmentToSecondActivity(message)
            findNavController().navigate(action)
        }
        btn_second_page.setOnClickListener {
            findNavController().navigate(R.id.secondFragment)
        }
        btn_third_page.setOnClickListener {
            findNavController().navigate(R.id.thirdFragment)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
