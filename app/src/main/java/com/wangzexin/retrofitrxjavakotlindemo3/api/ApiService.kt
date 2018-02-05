package com.wangzexin.retrofitrxjavakotlindemo3.api

import com.wangzexin.retrofitrxjavakotlindemo3.model.bean.LoginBean
import com.wangzexin.retrofitrxjavakotlindemo3.net.model.ResponseWrapper
import io.reactivex.Observable
import retrofit2.http.POST
import retrofit2.http.Query

/**
 *
 * @author wangzexin
 * @date 2018/1/23
 * @describe api服务
 */
interface ApiService {

    /**
     * 登录
     */
    @POST("app.php/login/login")
    fun requestLogin(@Query("uname") uname: String
                     , @Query("upwd") upwd: String): Observable<ResponseWrapper<LoginBean>>

}