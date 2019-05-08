package com.egecius.demo_androidplatform.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.egecius.demo_androidplatform.R

class Fragment3 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment3, container, false)
        view.findViewById<View>(R.id.pop_fragment_2).setOnClickListener { popTransactionFragment2() }
        return view
    }

    private fun popTransactionFragment2() {
        (activity as MyFragmentActivity).popTransactionFragment2()
    }
}
