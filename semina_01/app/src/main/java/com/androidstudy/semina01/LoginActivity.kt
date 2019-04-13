package com.androidstudy.semina01

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import java.lang.ref.ReferenceQueue
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    val REQUEST_CODE_LOGIN_ACTIVITY = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        et_login_id.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) v.setBackgroundResource(R.drawable.yellow_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        et_login_pw.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) v.setBackgroundResource(R.drawable.yellow_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        btn_login_submit.setOnClickListener {
            if (et_login_id.text.toString() == "") {
                et_login_id.requestFocus()
                toast("아이디를 입력하세요")
            } else if (et_login_pw.text.toString() == "") {
                et_login_pw.requestFocus()
                toast("비밀번호를 입력하세요")
            } else startActivity<MainActivity>()
        }
        tv_login_signup.setOnClickListener {
            val simpleDataFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val s_time = simpleDataFormat.format(Date())
            startActivityForResult<SignupActivity>(REQUEST_CODE_LOGIN_ACTIVITY, "start_time" to s_time)
        }
    }
    fun postLoginResponse(u_id:String, u_pw: String){
        SharedPreferenceController.setUserID(this,u_id)

        finish()
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE_LOGIN_ACTIVITY) {
            if(resultCode == Activity.RESULT_OK){
                val e_time = data!!.getStringExtra("end_time")

                toast("End time: ${e_time}")
            }
        }
    }
}
