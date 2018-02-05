package com.wangzexin.retrofitrxjavakotlindemo3.net

import android.util.Log
import com.wangzexin.retrofitrxjavakotlindemo3.api.ApiService
import com.wangzexin.retrofitrxjavakotlindemo3.app.MyApplication
import com.wangzexin.retrofitrxjavakotlindemo3.constant.MyConstant
import com.wangzexin.retrofitrxjavakotlindemo3.net.gson.CustomGsonConverterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 *
 * @author wangzexin
 * @date 2018/1/23
 * @describe
 */
object RetrofitManager {

    private var okHttpClient: OkHttpClient? = null
    private var retrofit: Retrofit? = null

    val service: ApiService by lazy { getRetrofit()!!.create(ApiService::class.java) }


    private fun getRetrofit(): Retrofit? {
        if (null == retrofit) {
            synchronized(RetrofitManager::class.java) {
                if (null == retrofit) {
                    //添加一个log拦截器
                    val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
                        override fun log(message: String?) {
                            Log.e("httpLogging", message)
                        }
                    })
                    //设置过滤的等级,body,basic,headers
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

                    //设置请求的缓存位置和大小
                    val cacheFile = File(MyApplication.context.cacheDir, "cache")
                    val cache = Cache(cacheFile, 1024 * 1024 * 50)

                    //初始化okhttpClient
                    okHttpClient = OkHttpClient.Builder()
                            .addInterceptor(httpLoggingInterceptor)
                            .cache(cache)
                            .connectTimeout(60L, TimeUnit.SECONDS)
                            .readTimeout(60L, TimeUnit.SECONDS)
                            .writeTimeout(60, TimeUnit.SECONDS)
                            .build()

                    //初始化Retrofit
                    retrofit = Retrofit.Builder()
                            .baseUrl(MyConstant.BASE_URL)
                            .client(okHttpClient)
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(CustomGsonConverterFactory.create())//GsonConverterFactory
                            .build()

                }
            }


        }

        return retrofit
    }

}