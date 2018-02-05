package com.wangzexin.retrofitrxjavakotlindemo3.mvp.model

import com.wangzexin.retrofitrxjavakotlindemo3.model.bean.LoginBean
import com.wangzexin.retrofitrxjavakotlindemo3.net.RetrofitManager
import com.wangzexin.retrofitrxjavakotlindemo3.net.model.ResponseWrapper
import com.wangzexin.retrofitrxjavakotlindemo3.utils.rxjava.SchedulerUtils
import io.reactivex.Observable

/**
 *
 * @author wangzexin
 * @date 2018/1/24
 * @describe
 */
class LoginModel {

    /**
     * 请求首页数据
     */
    fun requestHomeData(num: Int): Observable<ResponseWrapper<LoginBean>> {
        return RetrofitManager.service.requestLogin("15633843852","e10adc3949ba59abbe56e057f20f883e")
                .compose(SchedulerUtils.ioToMain())
//                .compose(RxUtil.handleResult<LoginBean>())
    }
}