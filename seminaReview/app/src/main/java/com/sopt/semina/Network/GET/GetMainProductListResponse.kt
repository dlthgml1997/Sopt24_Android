package com.sopt.semina.Network.GET

import com.sopt.semina.Data.ProductOverviewData

data class GetMainProductListResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: ArrayList<ProductOverviewData>?
)