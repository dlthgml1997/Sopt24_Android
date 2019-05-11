package org.sopt24.dshyun0226.androidseminar.Network.Post

data class PostLoginResponse(
    val status : Int,
    val seccess : Boolean,
    val message : String,
    val data : String?
)