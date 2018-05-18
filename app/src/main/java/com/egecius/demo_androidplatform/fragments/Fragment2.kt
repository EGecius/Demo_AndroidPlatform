package com.egecius.demo_androidplatform.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.egecius.demo_androidplatform.R

class Fragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment2, container, false)

        setOnClickListener(view)

        return view
    }

    private fun setOnClickListener(view: View) {
        view.findViewById<View>(R.id.to_fragment_3).setOnClickListener { showFragment3() }
    }

    private fun showFragment3() {
        (activity as MyFragmentActivity).showFragment3()
    }
}
