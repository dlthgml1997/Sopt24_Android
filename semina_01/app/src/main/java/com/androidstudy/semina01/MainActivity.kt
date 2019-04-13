package com.androidstudy.semina01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureTitleBar()
        txt_toolbar_main_action.setOnClickListener {
            if (SharedPreferenceController.getUserID(this).isEmpty()) {
                val intent: Intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }else{
                SharedPreferenceController.clearUserID(this)
                configureTitleBar()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        configureTitleBar()
    }

    private fun configureTitleBar() {
        if (SharedPreferenceController.getUserID(this).isEmpty()) {
            txt_toolbar_main_action.text = "로그인"
        } else {
            txt_toolbar_main_action.text = "로그아웃"
        }
    }


}