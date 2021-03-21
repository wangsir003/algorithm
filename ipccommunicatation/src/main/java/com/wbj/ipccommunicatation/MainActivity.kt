package com.wbj.ipccommunicatation

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Message
import android.os.Messenger
import android.view.View

class MainActivity : AppCompatActivity() {
    private var myConnection:MyConnection?=null
    private var mMsger:Messenger ?= null

    /**
     * 开启多进程注意事项：
     * 1.application 可能会走多次，导致多次初始化
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.tv_send).setOnClickListener {
            send()
        }


        //开启服务，服务单独在另一个进程中com.wbj.service
        val intent = Intent(this,MyService::class.java)
//        startService(intent)
        myConnection = MyConnection()
        bindService(intent,myConnection!!, Context.BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(myConnection!!)

    }

    private fun send(){
        mMsger?.let {
            val msg = Message.obtain(null,1)
            val bundle = Bundle()
            bundle.putString("key","传递消息")
            msg.data = bundle
            msg.replyTo = it
            it.send(msg)
        }

    }

    inner class MyConnection:ServiceConnection{
        override fun onServiceDisconnected(name: ComponentName?) {

        }

        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            mMsger = Messenger(service)
        }
    }


}