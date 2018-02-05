package com.wangzexin.retrofitrxjavakotlindemo3.app

import android.app.Application
import android.content.Context
import kotlin.properties.Delegates

/**
 * @author wangzexin
 * @date 2018/1/18
 * @describe
 */
class MyApplication : Application() {

    //相当于java的静态内部类，随类的初始化而初始化
    companion object {
        private val TAG = "MyApplication"
        var context: Context by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

}
