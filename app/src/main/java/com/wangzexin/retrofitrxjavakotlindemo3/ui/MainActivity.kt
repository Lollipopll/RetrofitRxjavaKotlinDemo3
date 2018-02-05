package com.wangzexin.retrofitrxjavakotlindemo3.ui

import android.os.Bundle
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
import com.wangzexin.retrofitrxjavakotlindemo3.R
import com.wangzexin.retrofitrxjavakotlindemo3.model.bean.LoginBean
import com.wangzexin.retrofitrxjavakotlindemo3.mvp.model.LoginModel
import com.wangzexin.retrofitrxjavakotlindemo3.net.callback.RequestCallback
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_request.setOnClickListener {

            val loginModel = LoginModel()

            loginModel.requestHomeData(1)
                    .bindUntilEvent(this, ActivityEvent.DESTROY)
                    .subscribe(object : RequestCallback<LoginBean>() {
                        override fun subscribe(d: Disposable) {

                        }

                        override fun success(data: LoginBean) {
                            tv_show.text = data.acctoken
                        }

                        override fun failure(statusCode: Int, msg: String) {
                            tv_show.text = "$statusCode"
                        }

                    })
        }
    }
}
