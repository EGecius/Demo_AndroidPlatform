package com.egecius.demo_androidplatform.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager.POP_BACK_STACK_INCLUSIVE
import android.util.Log
import com.egecius.demo_androidplatform.R

class MyFragmentActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_fragment)
        addBackStackListener()
        addFragment1()
    }

    private fun addBackStackListener() {
        supportFragmentManager.addOnBackStackChangedListener { Log.i("Eg:MyFragmentActivity:27", "onBackStackChanged ") }
    }

    private fun addFragment1() {
        Log.v("Eg:MyFragmentActivity:35", "addFragment1")
        replaceFragment(Fragment1(), true, TAG_FRAGMENT_1)
    }

    internal fun showFragment2() {
        Log.v("Eg:MyFragmentActivity:40", "showFragment2")
        replaceFragment(Fragment2(), true, TAG_FRAGMENT_2)
    }

    internal fun showFragment3() {
        Log.v("Eg:MyFragmentActivity:45", "showFragment3")
        replaceFragment(Fragment3(), true, TAG_FRAGMENT_3)
    }

    private fun replaceFragment(fragment: Fragment, useBackStack: Boolean, tag: String) {
        val transaction = supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)

        if (useBackStack) {
            transaction.addToBackStack(tag)
        }

        transaction.commit()
    }

    internal fun popTransactionFragment2() {
        supportFragmentManager.popBackStack(TAG_FRAGMENT_2, POP_BACK_STACK_INCLUSIVE)
    }

    companion object {

        private val TAG_FRAGMENT_1 = "Fragment1"
        private val TAG_FRAGMENT_2 = "Fragment2"
        private val TAG_FRAGMENT_3 = "Fragment3"
    }
}
