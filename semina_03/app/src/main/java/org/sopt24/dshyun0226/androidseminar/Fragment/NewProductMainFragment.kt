package org.sopt24.dshyun0226.androidseminar.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_new_product_main.*
import org.sopt24.dshyun0226.androidseminar.Adapter.ProductNewRecyclerViewAdapter
import org.sopt24.dshyun0226.androidseminar.Data.ProductNewData
import org.sopt24.dshyun0226.androidseminar.R

class NewProductMainFragment : Fragment()
{

    lateinit var productNewRecyclerViewAdatper : ProductNewRecyclerViewAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_product_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var dataList: ArrayList<ProductNewData> = ArrayList()
        dataList.add(ProductNewData("http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "무너지지 말자!","13만회","19.05.11"))
        dataList.add(ProductNewData("http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "무너지지 말자!","13만회","19.05.11"))
        dataList.add(ProductNewData("http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "무너지지 말자!","13만회","19.05.11"))
        dataList.add(ProductNewData("http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "무너지지 말자!","13만회","19.05.11"))
        dataList.add(ProductNewData("http://sopt.org/wp/wp-content/uploads/2014/01/24_SOPT-LOGO_COLOR-1.png",
            "무너지지 말자!","13만회","19.05.11"))

        productNewRecyclerViewAdatper = ProductNewRecyclerViewAdapter(context!!,dataList)
        rv_product_overview_new.adapter = productNewRecyclerViewAdatper
        rv_product_overview_new.layoutManager = LinearLayoutManager(context!!,LinearLayout.VERTICAL,false)
    }
}