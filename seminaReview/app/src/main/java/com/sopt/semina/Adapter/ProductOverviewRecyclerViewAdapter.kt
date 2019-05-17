package com.sopt.semina.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.sopt.semina.Activity.ProductActivity
import com.sopt.semina.Data.ProductOverviewData
import com.sopt.semina.R
import org.jetbrains.anko.startActivity

class ProductOverviewRecyclerViewAdapter(var ctx: Context, var dataList: ArrayList<ProductOverviewData>) :
    RecyclerView.Adapter<ProductOverviewRecyclerViewAdapter.Holder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ProductOverviewRecyclerViewAdapter.Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_product_overview, viewGroup, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
    Glide.with(ctx)
        .load(dataList[position].thumnail)
        .into(holder.img_thumbnail)

        holder.title.text = dataList[position].title
        holder.num_like.text = "♥" + dataList[position].likes
        holder.author.text = dataList[position].name
        holder.container.setOnClickListener {
            ctx.startActivity<ProductActivity>(
                "idx" to dataList[position].idx,
                "title" to dataList[position].title)
        }

    }

    override fun getItemCount() = dataList.size

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var container = itemView.findViewById(R.id.ll_rv_item_product_overview_container) as LinearLayout
        var img_thumbnail = itemView.findViewById(R.id.img_rv_item_product_overview_thunmbnail) as ImageView
        var title = itemView.findViewById(R.id.txt_rv_item_product_overview_title) as TextView
        var num_like = itemView.findViewById(R.id.txt_rv_item_product_overview_numlike) as TextView
        var author = itemView.findViewById(R.id.txt_rv_item_product_overview_author) as TextView
     }
}