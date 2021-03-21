package com.wbj.ipccommunicatation

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log

/**
 * 版权所有：特抱抱（杭州）科技有限公司
 * 开发者： apple
 * 创建日期：2021/2/21 下午5:46
 * 描述：
 */
class MyService : Service() {

    private val handler = MyHandler()

    inner class MyHandler: Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            when(msg.what){
                1 ->{
                    val data = msg.data
                    Log.e("MyService",(msg.obj as? String)?:"")
//                        Log.e("MyService",data["key"] as String)
                }
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    override fun onBind(intent: Intent?): IBinder? {
        return Messenger(handler).binder
    }

    override fun onDestroy() {
        super.onDestroy()

    }



}