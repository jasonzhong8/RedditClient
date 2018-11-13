package com.jasonzhong.redditclient.login_activity

class LoginPresenterImpl(private var loginView: LoginContract.LoginView?, private val loginInteractor: LoginContract.LoginInteractor) : LoginContract.LoginPresenter, LoginContract.OnLoginFinishedListener {

    override fun onDestroy() {
        loginView = null
    }

    override fun validateCredentials(username: String) {
        if (loginView != null) {
            loginView!!.showProgress()
        }

        loginInteractor.login(username, this)
    }

    override fun onUsernameError() {
        if (loginView != null) {
            loginView!!.setUsernameError()
            loginView!!.hideProgress()
        }
    }

    override fun onSuccess() {
        if (loginView != null) {
            loginView!!.navigateToHome()
        }
    }

}
