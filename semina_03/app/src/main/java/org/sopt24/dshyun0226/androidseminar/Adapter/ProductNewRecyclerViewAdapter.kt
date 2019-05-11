package org.sopt24.dshyun0226.androidseminar.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.rv_item_product_new.view.*
import org.sopt24.dshyun0226.androidseminar.Data.ProductNewData
import org.sopt24.dshyun0226.androidseminar.R

class ProductNewRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<ProductNewData>) : RecyclerView.Adapter<ProductNewRecyclerViewAdapter.Holder>(){

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_product_new,viewGroup,false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        Glide.with(ctx)
            .load(dataList[position].img_url)
            .into(holder.img_thumbnail)
        holder.title.text = dataList[position].title
        holder.num.text = dataList[position].view_count
        holder.date.text = dataList[position].date
     }

    inner class  Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var img_thumbnail = itemView.findViewById(R.id.img_rv_item_product_new_thumbnail) as ImageView
        var title = itemView.findViewById(R.id.txt_rv_item_product_new_title) as TextView
        var num = itemView.findViewById(R.id.txt_rv_item_product_new_view_count) as TextView
        var date = itemView.findViewById(R.id.txt_rv_item_product_new_date) as TextView

    }
}