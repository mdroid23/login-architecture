package com.kotlinlogin.kotlin_mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kotlinlogin.R
import com.kotlinlogin.Utils
import kotlinx.android.synthetic.main.layout_login.*

class LoginActivity : AppCompatActivity(),LoginContractView {

    var loginPresenter: LoginPresenter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        loginPresenter = LoginPresenter(this)
        btn_submit.setOnClickListener(View.OnClickListener {
            loginPresenter?.clickLogin()
        })
    }

    override fun getUserName(): String {
        return et_username.text.toString().trim()
    }

    override fun getPassword(): String {
        return et_password.text.toString().trim()
    }

    override fun setUserError(resId: Int) {
        et_username.error = getString(resId)
    }

    override fun setPasswordError(resId: Int) {
        et_password.error = getString(resId)
    }

    override fun showLoginSuccess() {
        Utils.showToast(this@LoginActivity,getString(R.string.str_success_login))
    }

    override fun showLoginFailure() {
        Utils.showToast(this@LoginActivity,getString(R.string.str_failed_login))
    }




}
