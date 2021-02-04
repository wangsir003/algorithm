package com.wbj.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.wbj.mvvm.databinding.MainActivityBinding
import com.wbj.mvvm.model.User

class MainActivity : AppCompatActivity() {

//    var binding : MainActivityBinding ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<MainActivityBinding>(this,R.layout.activity_main)
        var user = User("涨","停")
        binding.user = User("涨","停")
        binding.isShow = false
        val name = with(user,{
            this.firstName = "jfjfjfj"
            this.lastName = "jfjfjfj"
        })
        Log.e("MainActivity","first-")
        Handler().postDelayed({
//            val user = binding.user//更新值无用
//            user?.firstName = "吾问无为谓"
//            user?.lastName = "少时诵诗书"
            binding.user = User("吾问无为谓","少时诵诗书")
        },2000)


    }
}