/*******************************************************************************
 * Copyright 2017 Yuran Zhang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.wangzexin.retrofitrxjavakotlindemo3.net.callback


import com.wangzexin.retrofitrxjavakotlindemo3.net.model.ResponseWrapper
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *
 * @author wangzexin
 * @date 2018/1/25
 * @describe 通用的返回回调
 */
abstract class RequestCallback<T> : Observer<ResponseWrapper<T>> {
    abstract fun success(data: T)
    abstract fun failure(statusCode: Int, msg: String)
    abstract fun subscribe(d: Disposable)

    private object Status {
        const val SUCCESS = 200
    }

    override fun onSubscribe(d: Disposable) {
        subscribe(d)
    }

    override fun onNext(t: ResponseWrapper<T>) {
        if (t.code == Status.SUCCESS) {
            success(t.data)
            return
        }

        failure(t.code, ErrorDes.getErrorDesc(t.code.toString()))
    }

    override fun onComplete() {

    }

    override fun onError(e: Throwable) {
        val apiErrorModel = ExceptionHandle.handleException(e)
        failure(apiErrorModel.status, apiErrorModel.message)
    }
}
