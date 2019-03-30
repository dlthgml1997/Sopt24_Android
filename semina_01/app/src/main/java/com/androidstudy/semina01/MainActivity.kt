package com.androidstudy.semina01

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainLogin.setOnClickListener {
            startActivity<LoginActivity>("id" to 1)

        }

        btnMainClose.setOnClickListener {
            finish()
        }
    }
}