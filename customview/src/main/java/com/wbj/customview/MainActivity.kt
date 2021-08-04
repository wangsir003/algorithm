package com.wbj.customview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val surfView:SurfView = findViewById<SurfView>(R.id.surfView)
        surfView.setSlideCount(35)
        surfView.setSliderWidth(9)
        surfView.setMaxHeight(200)
        surfView.setSpace(3)
        surfView.setMode(0)
        surfView.setRadius(20)
        surfView.setColor(Color.RED)
        surfView.setGroupChild(7)
        surfView.initArr()


        val surfView2:SurfView = findViewById<SurfView>(R.id.surfView2)
        surfView2.setSlideCount(35)
        surfView2.setSliderWidth(9)
        surfView2.setMaxHeight(60)
        surfView2.setSpace(3)
        surfView2.setMode(1)
        surfView2.setRadius(20)
        surfView2.setColor(Color.RED)
        surfView2.setGroupChild(7)
        surfView2.initArr()


    }
}