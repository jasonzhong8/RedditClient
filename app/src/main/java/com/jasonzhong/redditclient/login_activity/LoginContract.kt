package com.jasonzhong.redditclient.login_activity

interface LoginContract {

    interface LoginPresenter {

        fun onDestroy()

        fun validateCredentials(username: String)

        fun onUsernameError()

        fun onSuccess()
    }

    interface LoginInteractor {

        fun login(userName: String, listener: OnLoginFinishedListener)
    }

    interface OnLoginFinishedListener {
        fun onUsernameError()

        fun onSuccess()
    }

    interface LoginView {

        fun showProgress()

        fun hideProgress()

        fun setUsernameError()

        fun navigateToHome()

    }
}
