package com.sopt.semina.Activity

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.manager.SupportRequestManagerFragment
import com.sopt.semina.Adapter.ProductMainPagerAdapter
import com.sopt.semina.Adapter.ProductOverviewRecyclerViewAdapter
import com.sopt.semina.Adapter.SliderMainPagerAdapter
import com.sopt.semina.DB.SharedPreferenceController
import com.sopt.semina.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureTitleBar()
        configureMainTab()
        setOnBtnClickListener()
    }

    override fun onResume() {
        super.onResume()
        configureTitleBar()
    }

    private fun configureTitleBar() {
        img_toolbar_main_action.isSelected = !SharedPreferenceController.getUserToken(this).isEmpty()
    }

    private fun setOnBtnClickListener() {
        img_toolbar_main_action.setOnClickListener {
            if (SharedPreferenceController.getUserToken(this).isEmpty()) {
                startActivity<LoginActivity>()
            } else {
                SharedPreferenceController.clearUserToken(this)
                configureTitleBar()
            }
        }
    }

    private fun configureMainTab() {
        vp_main_product.adapter = ProductMainPagerAdapter(supportFragmentManager, 3)
        vp_main_product.offscreenPageLimit = 2
        tl_main_category.setupWithViewPager(vp_main_product)

        val navCategoryMainLayout: View = (this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(R.layout.navigation_category_main, null, false)
        tl_main_category.getTabAt(0)!!.customView = navCategoryMainLayout
            .findViewById(R.id.rl_nav_category_main_all) as RelativeLayout
        tl_main_category.getTabAt(1)!!.customView = navCategoryMainLayout
            .findViewById(R.id.rl_nav_category_main_new) as RelativeLayout
        tl_main_category.getTabAt(2)!!.customView = navCategoryMainLayout
            .findViewById(R.id.rl_nav_category_main_end)

        vp_main_slider.adapter = SliderMainPagerAdapter(supportFragmentManager,3)
        vp_main_slider.offscreenPageLimit = 2
        tl_main_indicator.setupWithViewPager(vp_main_slider)
    }


}
