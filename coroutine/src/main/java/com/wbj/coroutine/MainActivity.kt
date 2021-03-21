package com.wbj.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.provider.Settings
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStore
import kotlinx.coroutines.*

/**
 * 协程
 * 本质：多线程
 */
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvTxt = findViewById<TextView>(R.id.tv_txt)


        GlobalScope.launch(Dispatchers.Main) {
            println("Dispatchers.Main:" + Thread.currentThread().name + " 优先级" + Thread.currentThread().priority)
        }
        GlobalScope.launch(Dispatchers.IO) {
            println("Dispatchers.IO:" + Thread.currentThread().name + " 优先级" + Thread.currentThread().priority)
        }
        GlobalScope.launch(Dispatchers.Default) {
            println("Dispatchers.Default:" + Thread.currentThread().name + " 优先级" + Thread.currentThread().priority)
        }
        GlobalScope.launch(Dispatchers.Unconfined) {
            println("Dispatchers.Unconfined:" + Thread.currentThread().name + " 优先级" + Thread.currentThread().priority)
        }
        GlobalScope.launch(Dispatchers.Main) {
            //模拟耗时操作1
            val start = System.currentTimeMillis()
            //用法一 ：直接在协程中使用withContext挂起函数
//            val result1= withContext(Dispatchers.IO){
//                analogRequest1()
//            }
            //用法二 ：使用suspend 挂起函数
            val result1 = suspendAnalogRequest1()
            val end = System.currentTimeMillis()

            //模拟耗时操作2
            val start2 = System.currentTimeMillis()
//            val result2= withContext(Dispatchers.IO){
//                analogRequest2()
//            }
            val result2 = asuspendAnalogRequest2()
            val end2 = System.currentTimeMillis()

            //两次请求结束，合并数据显示
            withContext(Dispatchers.Main){
                Toast.makeText(this@MainActivity,"$result1  $result2",Toast.LENGTH_LONG).show()

                tvTxt.text = "" +
                        "请求1开始时间 $start \n " +
                        "请求1结束时间 $end \n" +
                        "请求1结果 $result1 \n" +
                        "请求2开始时间 $start2 \n " +
                        "请求2结束时间 $end2 \n" +
                        "请求2结果 $result2 \n" +
                        "请求合并结果 $result1 $result2"


            }
        }
    }

    /**
     * 模拟耗时的网络请求2
     */
    private fun analogRequest1():String{
        var sum = 0
        repeat(10000000){
            sum += it
        }
        return "结果：$sum"
    }
    /**
     * 模拟耗时的网络请求2
     */
    private suspend fun  suspendAnalogRequest1():String{
        return analogRequest1()
    }

    /**
     * 模拟耗时的网络请求
     */
    private fun analogRequest2():String{
        var sum = 0
        repeat(100000000){
            sum += it
        }
        return "结果：$sum"
    }
    /**
     * 模拟耗时的网络请求
     */
    private suspend fun asuspendAnalogRequest2():String{
        return analogRequest2()
    }


}