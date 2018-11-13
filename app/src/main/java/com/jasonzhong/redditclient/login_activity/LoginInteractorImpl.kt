package com.jasonzhong.redditclient.login_activity

import android.os.Handler
import android.text.TextUtils

class LoginInteractorImpl : LoginContract.LoginInteractor {

    override fun login(username: String, listener: LoginContract.OnLoginFinishedListener) {

        Handler().postDelayed(Runnable {
            if ((TextUtils.isEmpty(username)) or (!username.matches("[a-zA-Z ]+".toRegex())) or (username.length > 20)) {
                listener.onUsernameError()
                return@Runnable
            }

            listener.onSuccess()
        }, 1500)
    }

}
