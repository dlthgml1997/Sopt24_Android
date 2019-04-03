package com.androidstudy.semina01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        et_login_id.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.yellow_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        et_login_pw.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.yellow_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        btn_login_submit.setOnClickListener {
            if(et_login_id.text.toString()== ""){
                et_login_id.requestFocus()
                toast("아이디를 입력하세요")
            }else if(et_login_pw.text.toString()== ""){
                et_login_pw.requestFocus()
                toast("비밀번호를 입력하세요")
            }else startActivity<MainActivity>()
        }



        val id = intent.getIntExtra("id",1)
        Toast.makeText(this,"id : ${id}",Toast.LENGTH_SHORT).show()
            //toast("id : ${id}")
    }
}
