package com.sopt.semina.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt.semina.Adapter.ProductOverviewRecyclerViewAdapter
import com.sopt.semina.Data.ProductOverviewData
import com.sopt.semina.Network.ApplicationController
import com.sopt.semina.Network.GET.GetMainProductListResponse
import com.sopt.semina.Network.NetworkService
import com.sopt.semina.R
import kotlinx.android.synthetic.main.fragment_all_product_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllProductMainFragment : Fragment() {
    val networkService : NetworkService by lazy{
        ApplicationController.instance.networkService
    }

    lateinit var productOverviewRecyclerViewAdapter : ProductOverviewRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_all_product_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var dataList: ArrayList<ProductOverviewData> = ArrayList()

        productOverviewRecyclerViewAdapter = ProductOverviewRecyclerViewAdapter(context!!,dataList)
        rv_product_overview_all.adapter = productOverviewRecyclerViewAdapter
        rv_product_overview_all.layoutManager = GridLayoutManager(context!!,3)


        getMainProductListResponse()
    }

    fun getMainProductListResponse(){
        val getMainProductListResponse = networkService.getMainProductListResponse("application/json",1)
        getMainProductListResponse.enqueue(object: Callback<GetMainProductListResponse>{
            override fun onFailure(call: Call<GetMainProductListResponse>, t: Throwable) {
                Log.e("AllMainProduct Fail",t.toString())
            }

            override fun onResponse(
                call: Call<GetMainProductListResponse>,
                response: Response<GetMainProductListResponse>
            ) {
            if(response.isSuccessful){
                if(response.body()!!.status ==200){
                    val tmp: ArrayList<ProductOverviewData> = response.body()!!.data!!
                    productOverviewRecyclerViewAdapter.dataList = tmp
                    productOverviewRecyclerViewAdapter.notifyDataSetChanged()
                }
            }
            }
        })
    }
}
