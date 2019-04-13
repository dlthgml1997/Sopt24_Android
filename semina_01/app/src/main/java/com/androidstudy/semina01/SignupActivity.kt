package com.androidstudy.semina01

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androidstudy.semina01.R.id.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        setOnBtnFocusListener()
        setOnBtnClickListener()
    }
    fun setOnBtnFocusListener(){
        et_signup_id.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.yellow_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }
        et_signup_pw.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.yellow_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }
        et_signup_name.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.yellow_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }
    }
    fun setOnBtnClickListener(){
        btn_signup_submit.setOnClickListener {
            if(et_signup_id.text.toString() == ""){
                et_signup_id.requestFocus()
            }else if(et_signup_name.text.toString() == ""){
                et_signup_name.requestFocus()
            }else if(et_signup_pw.text.toString() == ""){
                et_signup_pw.requestFocus()
            }else {
                postSignupResponse(et_signup_id.text.toString(),et_signup_pw.text.toString(),et_signup_name.text.toString())
                finish()
            }
        }
    }

    fun postSignupResponse(u_id: String, u_pw: String, u_name:String){
        val simpleDataFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val e_time= simpleDataFormat.format(Date())

        val intent: Intent = Intent()
        intent.putExtra("end_time",e_time)
        setResult(Activity.RESULT_OK, intent)

        finish()
    }


}