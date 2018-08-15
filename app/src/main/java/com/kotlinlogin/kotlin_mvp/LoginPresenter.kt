package com.kotlinlogin.kotlin_mvp

import android.text.TextUtils
import com.kotlinlogin.R

class LoginPresenter(val contractView: LoginContractView) {

    fun clickLogin() {
        val userName: String = contractView.getUserName()
        val password: String = contractView.getPassword()
        if (TextUtils.isEmpty(userName)) {
            contractView.setUserError(R.string.err_username)
        } else if (TextUtils.isEmpty(password)) {
            contractView.setPasswordError(R.string.err_password)
        } else if (!userName.equals(password)) {
            contractView.showLoginFailure()
        } else {
            contractView.showLoginSuccess()
        }
    }
}