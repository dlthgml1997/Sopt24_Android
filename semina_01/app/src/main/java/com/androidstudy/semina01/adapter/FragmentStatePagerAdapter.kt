package com.androidstudy.semina01.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.androidstudy.semina01.AllProductMainFragment
import com.androidstudy.semina01.EndProductMainFragment
import com.androidstudy.semina01.NewProductMainFragment

class FragmentStatePagerAdapter(fm: FragmentManager, private val num_fragment : Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment? {
        return when(p0) {
            0 -> AllProductMainFragment()
            1 -> NewProductMainFragment()
            2 -> EndProductMainFragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return num_fragment
    }
}