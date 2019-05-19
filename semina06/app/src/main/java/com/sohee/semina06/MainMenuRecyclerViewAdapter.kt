package com.sohee.semina06

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MainMenuRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<MainMenuData>) : RecyclerView.Adapter<MainMenuRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_main_menu,p0,false)
        return Holder(view)
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {

    }

    override fun getItemCount(): Int = dataList.size

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}