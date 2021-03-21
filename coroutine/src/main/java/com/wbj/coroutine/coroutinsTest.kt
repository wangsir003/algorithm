package com.wbj.coroutine

import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/3/20 下午4:07
 * 描述：
 */

fun main() {
    println("main()---->")
//
    GlobalScope.launch(Dispatchers.IO) {
        println("GlobalScope.launch(Dispatchers.IO) {")
        //模拟耗时操作1
        val start = System.currentTimeMillis()
        //用法一 ：直接在协程中使用withContext挂起函数
//            val result1= withContext(Dispatchers.IO){
//                analogRequest1()
//            }
        //用法二 ：使用suspend 挂起函数
        val result1 = suspendAnalogRequest1()
        println(result1)

        val end = System.currentTimeMillis()

        //模拟耗时操作2
        val start2 = System.currentTimeMillis()
//            val result2= withContext(Dispatchers.IO){
//                analogRequest2()
//            }
        val result2 = suspendAnalogRequest2()
        println(result2)
        val end2 = System.currentTimeMillis()

        //两次请求结束，合并数据显示
        withContext(Dispatchers.Main){

                    val result = "请求1开始时间 $start \n " +
                    "请求1结束时间 $end \n" +
                    "请求1结果 $result1 \n" +
                    "请求2开始时间 $start2 \n " +
                    "请求2结束时间 $end2 \n" +
                    "请求2结果 $result2 \n" +
                    "请求合并结果 $result1 $result2"
//            result.logi()
            println(result)

        }
    }


}

/**
 * 模拟耗时的网络请求2
 */
fun analogRequest1():String{
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
private suspend fun suspendAnalogRequest2():String{
    return analogRequest2()
}