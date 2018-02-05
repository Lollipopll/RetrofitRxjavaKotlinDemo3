package com.wangzexin.retrofitrxjavakotlindemo3.net.model

import com.google.gson.annotations.SerializedName
import com.wangzexin.retrofitrxjavakotlindemo3.net.callback.ErrorCode

/**
 * @author wangzexin
 * @date 2018/1/26
 * @describe 自定义Gson解析时判断code的实体类
 */
class HttpStatus {
    @SerializedName("code")
    val code: String? = null
    @SerializedName("message")
    val message: String? = null

    /**
     * API是否请求失败
     *
     * @return 失败返回true, 成功返回false
     */
    val isCodeInvalid: Boolean
        get() = code != ErrorCode.CODE_SUCCESS
}

