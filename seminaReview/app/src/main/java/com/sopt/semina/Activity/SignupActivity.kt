package com.sopt.semina.Activity

import android.app.Activity
import android.content.Intent
import android.opengl.ETC1.isValid
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.sopt.semina.Network.ApplicationController
import com.sopt.semina.Network.NetworkService
import com.sopt.semina.Network.POST.PostSignupResponse
import com.sopt.semina.R
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy{
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val s_time = intent.getStringExtra("start_time")
        toast("Current time: ${s_time}")

        val edtOnFocusChangeListener: View.OnFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        edtSignupName.setOnFocusChangeListener(edtOnFocusChangeListener)
        edtSignupID.setOnFocusChangeListener(edtOnFocusChangeListener)
        edtSignupPW.setOnFocusChangeListener(edtOnFocusChangeListener)

        btnSignupSubmit.setOnClickListener {
            val signup_u_name : String = edtSignupName.text.toString()
            val signup_u_id : String = edtSignupID.text.toString()
            val signup_u_pw : String = edtSignupPW.text.toString()
            if(isValid(signup_u_id,signup_u_pw,signup_u_name)){
                postSignupResponse(signup_u_id, signup_u_pw, signup_u_name)
            }
        }
    }

    private fun postSignupResponse(u_id: String, u_pw: String, u_name: String) {
        var jsonObject = JSONObject()
        jsonObject.put("id",u_id)
        jsonObject.put("password",u_pw)
        jsonObject.put("name",u_name)

        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject
        val postSignupResponse : Call<PostSignupResponse> =
            networkService.postSignupResponse("application/json",gsonObject)
        postSignupResponse.enqueue(object : Callback<PostSignupResponse>{
            override fun onFailure(call: Call<PostSignupResponse>, t: Throwable) {
                Log.e("Signup failed",t.toString())
            }

            override fun onResponse(call: Call<PostSignupResponse>, response: Response<PostSignupResponse>) {
                if(response.isSuccessful){
                    toast(response.body()!!.message)
                    if(response.body()!!.status ==201)
                    {
                        val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
                        val e_time = simpleDateFormat.format(Date())

                        val intent: Intent = Intent()
                        intent.putExtra("end_time",e_time)
                        setResult(Activity.RESULT_OK,intent)

                        finish()

                    }
                }
            }
        })

    }

    fun isValid(u_id: String,u_pw:String,u_name: String) : Boolean{
        if(u_name == "") edtSignupName.requestFocus()
        else if(u_id == "") edtSignupID.requestFocus()
        else if(u_pw == "") edtSignupPW.requestFocus()
        else return true
        return false
    }
}
