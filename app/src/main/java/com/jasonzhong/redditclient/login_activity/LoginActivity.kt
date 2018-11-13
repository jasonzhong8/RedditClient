package com.jasonzhong.redditclient.login_activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.jasonzhong.redditclient.R
import com.jasonzhong.redditclient.items_activity.ItemsActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    private var presenter: LoginPresenterImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener { validateCredentials() }

        presenter = LoginPresenterImpl(this, LoginInteractorImpl())
    }

    private fun validateCredentials() {
        presenter!!.validateCredentials(username_editText!!.text.toString())
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
    }

    override fun setUsernameError() {
        username_editText!!.error = getString(R.string.username_error)
    }

    override fun navigateToHome() {
        val intent = Intent(this@LoginActivity, ItemsActivity::class.java)
        intent.putExtra("Username",username_editText.text.toString())
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        presenter!!.onDestroy()
        super.onDestroy()
    }
}
