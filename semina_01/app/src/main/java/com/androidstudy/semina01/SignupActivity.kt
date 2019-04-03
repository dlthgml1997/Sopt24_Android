package com.androidstudy.semina01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androidstudy.semina01.R.id.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

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
            }else startActivity<LoginActivity>()
        }
    }

}