package com.wbj.customview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val surfView:SurfView = findViewById<SurfView>(R.id.surfView)
        surfView.setSlideCount(4)
        surfView.setSliderWidth(9)
        surfView.setColor(Color.RED)
    }
}