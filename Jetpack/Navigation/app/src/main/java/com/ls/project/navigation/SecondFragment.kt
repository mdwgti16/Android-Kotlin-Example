package com.ls.project.navigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_send.setOnClickListener {
            val bundle = bundleOf("message" to editText.text.toString())
            findNavController().navigate(R.id.thirdFragment, bundle)

            val message = editText.text.toString()
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment(message)
            findNavController().navigate(action)

        }
    }
}

