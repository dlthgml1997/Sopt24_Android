package com.sopt.semina.Data

data class EpisodeOverviewData(
    var product_id: Int,
    var episode_id: Int,
    var img_url: String,
    var title:String,
    var num_view : Int,
    var publish_date: String
    )