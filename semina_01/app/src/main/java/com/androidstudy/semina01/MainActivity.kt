package com.androidstudy.semina01

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.androidstudy.semina01.adapter.FragmentStatePagerAdapter
import com.androidstudy.semina01.db.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureMainTab()
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
    private fun configureMainTab() {
        vp_main_product.adapter = FragmentStatePagerAdapter(supportFragmentManager,3)
        vp_main_product.offscreenPageLimit =2
        tl_main_category.setupWithViewPager(vp_main_product)

        val navCategoryMainLayout: View = (this.getSystemService(android.content.Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.navigation_category_main,null,false)
        tl_main_category.getTabAt(0)!!.customView= navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_all) as RelativeLayout
        tl_main_category.getTabAt(1)!!.customView= navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_new) as RelativeLayout
        tl_main_category.getTabAt(2)!!.customView= navCategoryMainLayout.findViewById(R.id.rl_nav_category_main_end) as RelativeLayout
    }
    private fun configureDotIndicator() {
        vp_main_dot_indicator.adapter = FragmentStatePagerAdapter(supportFragmentManager,3)
        vp_main_dot_indicator.offscreenPageLimit =2
        tl_main_dot_indicator.setupWithViewPager(vp_main_dot_indicator)

    }



}