package  com.wangzexin.retrofitrxjavakotlindemo3.utils.rxjava

import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe


/**
 * Created by xuhao on 2017/11/17.
 * desc:
 */

object SchedulerUtils {

    fun <T> ioToMain(): IoMainScheduler<T> {
        return IoMainScheduler()
    }

//    /**
//     * 统一返回结果处理
//     *
//     * @param <T>
//     * @return
//    </T> */
//    fun <T> handleResult(): ObservableTransformer<BaseResponse<T>, T> {
//        return object : ObservableTransformer<BaseResponse<T>, T> {
//            override fun apply(upstream: Observable<BaseResponse<T>>): ObservableSource<T> {
//                return upstream.flatMap(object : Function<BaseResponse<T>, Observable<T>>() {
//                    fun apply(t: BaseResponse<T>): Observable<T> {
//                        return if (t.code == 200) {
//                            createData(t.data)
//                        } else {
//                            Observable.error(ApiException("服务器返回error"))
//                        }
//                    }
//                })
////                        .onErrorResumeNext(object : Function<Throwable, ObservableSource<out T>>() {
////                            @Throws(Exception::class)
////                            fun apply(throwable: Throwable): ObservableSource<out T> {
////                                //处理异常
////                                return Observable.error(ExceptionHandle.handleException(throwable))
////                            }
////                        })
//            }
//        }
//    }


    /**
     * 生成Observable
     *
     * @param <T>
     * @return
    </T> */
    fun <T> createData(t: T): Observable<T> {

        return Observable.create(ObservableOnSubscribe<T> { emitter ->
            try {
                emitter.onNext(t)
                emitter.onComplete()
            } catch (e: Exception) {
                emitter.onError(e)
            }
        })
    }
}
