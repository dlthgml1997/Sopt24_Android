package org.sopt24.dshyun0226.androidseminar.Network.Get

import org.sopt24.dshyun0226.androidseminar.Data.ProductOverviewData

class GetMainProductListResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: ArrayList<ProductOverviewData>?
)