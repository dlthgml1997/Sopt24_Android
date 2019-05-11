package org.sopt24.dshyun0226.androidseminar.Network

import com.google.gson.JsonObject
import org.sopt24.dshyun0226.androidseminar.Network.Post.PostLoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface NetworkService {
    @POST("/api/auth/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type : String,
        @Body body:JsonObject
    ): Call<PostLoginResponse>
}