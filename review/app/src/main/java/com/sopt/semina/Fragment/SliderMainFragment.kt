package com.sopt.semina.Fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.sopt.semina.R
import kotlinx.android.synthetic.main.fragment_slider_main.*

class SliderMainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_slider_main,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val img_url : String =  arguments!!.getString("background_url")

        Glide.with(this)
            .load(img_url)
            .into(img_fragment_slider_main)
    }

}