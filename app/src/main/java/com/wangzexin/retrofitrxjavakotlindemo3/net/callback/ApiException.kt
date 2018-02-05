package com.wangzexin.retrofitrxjavakotlindemo3.net.callback

/**
 *
 * @author wangzexin
 * @date 2018/1/26
 * @describe
 */
class ApiException : RuntimeException {
    var code: String

    //    public ApiException (int errorCode, String errorMessage)
//    {
//        super(errorMessage);
//        mErrorCode = errorCode;
//    }
    constructor(code: String, msg: String) : super(msg) {
        this.code = code
    }
//    /**
//     * 判断是否是token失效
//     *
//     * @return 失效返回true, 否则返回false;
//     */
//    public boolean isTokenExpried()
//    {
//        return mErrorCode == Constants.TOKEN_EXPRIED;
//    }
}